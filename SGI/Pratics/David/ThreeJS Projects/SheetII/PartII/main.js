import * as THREE from 'three';
import { OrbitControls } from 'three/addons/controls/OrbitControls.js';
import Stats from 'three/addons/libs/stats.module.js';
import { GLTFLoader } from 'three/addons/loaders/GLTFLoader.js';

const scene = new THREE.Scene();
const camera = new THREE.PerspectiveCamera(70, window.innerWidth / window.innerHeight, 0.1, 50);
const myCanvas = document.getElementById('myCanvas');
const renderer = new THREE.WebGLRenderer({ canvas: myCanvas, antialias: true });
const controls = new OrbitControls(camera, renderer.domElement);
const stats = new Stats();
const status = document.getElementById('status');

const raycaster = new THREE.Raycaster();
const rato = new THREE.Vector2();
const botoes = [];
let cuboGrande = null;
let estadoInicial = null;

// O cubo grande tem uma cópia própria para não alterar os cubos pequenos.
function aplicarMaterial(material) {
  cuboGrande.material.dispose();
  cuboGrande.material = material;
}

document.getElementById('btnColor').onclick = () => {
  cuboGrande.material.color.setRGB(Math.random(), Math.random(), Math.random());
};
document.getElementById('btnMaterial').onclick = () => {
  aplicarMaterial(new THREE.MeshStandardMaterial({ metalness: 1, roughness: 0.5 }));
};
document.getElementById('btnShadow').onclick = () => {
  cuboGrande.castShadow = !cuboGrande.castShadow;
  cuboGrande.receiveShadow = cuboGrande.castShadow;
};
document.getElementById('btnHideAndSeek').onclick = () => {
  cuboGrande.visible = !cuboGrande.visible;
};
document.getElementById('btnReset').onclick = () => {
  aplicarMaterial(estadoInicial.material.clone());
  cuboGrande.castShadow = estadoInicial.castShadow;
  cuboGrande.receiveShadow = estadoInicial.receiveShadow;
  cuboGrande.visible = estadoInicial.visible;
};

camera.position.set(4, 3, 2);
controls.target.set(0, 0.5, 0);
controls.update();

renderer.setPixelRatio(Math.min(window.devicePixelRatio, 2));
renderer.setSize(window.innerWidth, window.innerHeight);
renderer.shadowMap.enabled = true;
document.body.appendChild(stats.dom);

const pointLight = new THREE.PointLight('white', 30);
pointLight.position.set(5, 6, 0);
pointLight.castShadow = true;
scene.add(pointLight);

new GLTFLoader().load('cena.gltf', (gltf) => {
  scene.add(gltf.scene);

  // Só as malhas dos cubos pequenos são candidatas à seleção.
  gltf.scene.traverse((elemento) => {
    if (!elemento.isMesh) return;
    elemento.castShadow = true;
    elemento.receiveShadow = true;

    if (elemento.name === 'Cubo') cuboGrande = elemento;
    if (elemento.name.includes('Botao')) botoes.push(elemento);
  });

  if (!cuboGrande) {
    status.textContent = 'O modelo não contém o objeto Cubo.';
    return;
  }
  estadoInicial = {
    material: cuboGrande.material.clone(),
    castShadow: cuboGrande.castShadow,
    receiveShadow: cuboGrande.receiveShadow,
    visible: cuboGrande.visible
  };
  cuboGrande.material = cuboGrande.material.clone();
  document.getElementById('acoes').disabled = false;
  status.textContent = 'Clica num cubo pequeno para aplicar o seu material ao cubo grande. Arrasta para rodar; usa a roda para aproximar.';
}, undefined, (error) => {
  status.textContent = 'Não foi possível carregar a cena. Abre esta página através de um servidor local.';
  console.error('Erro ao carregar cena.gltf:', error);
});

function pegarPrimeiro(evento) {
  if (!cuboGrande) return;

  // Coordenadas do rato relativas ao canvas, normalizadas para [-1, 1].
  const limites = myCanvas.getBoundingClientRect();
  rato.x = ((evento.clientX - limites.left) / limites.width) * 2 - 1;
  rato.y = -((evento.clientY - limites.top) / limites.height) * 2 + 1;

  scene.updateMatrixWorld(true);
  camera.updateMatrixWorld();
  raycaster.setFromCamera(rato, camera);
  const intersetados = raycaster.intersectObjects(botoes, false);

  if (intersetados.length > 0) {
    // Copia todas as propriedades, mantendo independente o botão Mudar Cor.
    aplicarMaterial(intersetados[0].object.material.clone());
  }
}

// Evita selecionar um material no fim de um arrastamento com OrbitControls.
let inicioClique = null;
myCanvas.addEventListener('pointerdown', (evento) => {
  if (!evento.isPrimary || evento.button !== 0) {
    inicioClique = null;
    return;
  }
  inicioClique = { id: evento.pointerId, x: evento.clientX, y: evento.clientY };
});
myCanvas.addEventListener('pointermove', (evento) => {
  if (inicioClique && Math.hypot(evento.clientX - inicioClique.x, evento.clientY - inicioClique.y) > 5) {
    inicioClique = null;
  }
});
myCanvas.addEventListener('pointerup', (evento) => {
  if (inicioClique && inicioClique.id === evento.pointerId) pegarPrimeiro(evento);
  inicioClique = null;
});
myCanvas.addEventListener('pointercancel', () => { inicioClique = null; });

window.addEventListener('resize', () => {
  camera.aspect = window.innerWidth / window.innerHeight;
  camera.updateProjectionMatrix();
  renderer.setSize(window.innerWidth, window.innerHeight);
});

function animate() {
  requestAnimationFrame(animate);
  controls.update();
  stats.update();
  renderer.render(scene, camera);
}
animate();
