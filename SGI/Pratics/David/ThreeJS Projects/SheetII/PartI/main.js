import * as THREE from 'three';
import { OrbitControls } from 'three/addons/controls/OrbitControls.js';
import Stats from 'three/addons/libs/stats.module.js';
import { GLTFLoader } from 'three/addons/loaders/GLTFLoader.js'

const scene = new THREE.Scene();
const camera = new THREE.PerspectiveCamera(70, 800 / 600, 0.1, 50);
let myCanvas = document.getElementById('myCanvas')
let renderer = new THREE.WebGLRenderer({ canvas: myCanvas });
let controls = new OrbitControls(camera, renderer.domElement);
const stats = new Stats();

let bigSur = null
let reseted = null
let charger = new GLTFLoader()
const pointLight = new THREE.PointLight("white")
/*let delta = 0;
const watch = new THREE.Timer();
const minlat = 1 / 60;*/


camera.position.set(4, 3, 2);
camera.lookAt(0, 0, 0);

renderer.setSize(800, 600);
document.body.appendChild(renderer.domElement);

controls.target.set(0, 0.5, 0);
controls.update();

document.body.appendChild(stats.dom);

charger.load(
  'cena.gltf',
  function (gltf) {
    scene.add(gltf.scene)
    pointLight.casthadow = true;
    renderer.shadowMap.enabled = true;

    scene.traverse(function(element){
      element.castShadow = true;
      element.receiveShadow = true;
      if(element.name == "Cubo"){
        bigSur = element;
      }
    });

    reseted = {
      material: bigSur.material.clone(),
      castShadow: bigSur.castShadow,
      receiveShadow: bigSur.receiveShadow,
      visible: bigSur.visible
    };

  }
)

pointLight.position.set(4, 3, 0)
pointLight.intensity = 30
scene.add(pointLight)

function animate() {
  requestAnimationFrame(animate);
  controls.update();
  stats.update();
  renderer.render(scene, camera);
}

animate();


console.log('bigSur -> ' + bigSur)
console.log('reseted -> ' + reseted)

let newMaterial = new THREE.MeshStandardMaterial({
  metalness: 1, // entre 0 e 1
  roughness: 0.5 // entre 0 e 1
});

document.getElementById('btnColor').onclick = function() {
  bigSur.material.color = new THREE.Color(Math.random(), Math.random(), Math.random());
}

document.getElementById('btnMaterial').onclick = function() {
  bigSur.material = new THREE.MeshStandardMaterial({
    metalness: 1, // entre 0 e 1
    roughness: 0.5 // entre 0 e 1
  });
}

document.getElementById('btnShadow').onclick = function() {
  if(bigSur.castShadow) {
    bigSur.castShadow = false
    bigSur.receiveShadow = false
  }else{
    bigSur.castShadow = true
    bigSur.receiveShadow = true
  }
}

document.getElementById('btnHideAndSeek').onclick = function() {
  if(bigSur.visible){
    bigSur.visible = false
  }else{
    bigSur.visible = true
  }
}

document.getElementById('btnReset').onclick = function () {
  if (!bigSur || !reseted) return;

  bigSur.material = reseted.material.clone();
  bigSur.castShadow = reseted.castShadow;
  bigSur.receiveShadow = reseted.receiveShadow;
  bigSur.visible = reseted.visible;
};
