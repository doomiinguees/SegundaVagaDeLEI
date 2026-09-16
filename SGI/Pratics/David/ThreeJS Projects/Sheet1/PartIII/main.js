import * as THREE from 'three';

// Criar um cubo 1x1x1.
const geometria = new THREE.BoxGeometry(1, 1, 1);
const material = new THREE.MeshNormalMaterial();
const cubo = new THREE.Mesh(geometria, material);

// Criar a cena e colocar nela o cubo.
const cena = new THREE.Scene();
cena.add(cubo);

// Criar e configurar o renderer.
const renderer = new THREE.WebGLRenderer();
renderer.setSize(800, 600);
document.body.appendChild(renderer.domElement);

// Criar e posicionar a câmara.
const camara = new THREE.PerspectiveCamera(70, 800 / 600, 0.01, 1000);
camara.position.z = 5;

// Renderizar e animar, limitando as atualizações a 60 por segundo.
let delta = 0;
const relogio = new THREE.Timer();
const latenciaMinima = 1 / 60;

function animar() {
  requestAnimationFrame(animar);

  relogio.update();
  delta += relogio.getDelta();

  if (delta < latenciaMinima) return;

  cubo.rotateX(0.01);
  cubo.rotateY(0.02);
  renderer.render(cena, camara);

  delta %= latenciaMinima;
}

animar();
