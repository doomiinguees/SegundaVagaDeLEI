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

let charger = new GLTFLoader()
const pointLight = new THREE.PointLight("offwhite")
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