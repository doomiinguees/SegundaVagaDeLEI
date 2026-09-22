import * as THREE from 'three';
import { OrbitControls } from 'three/addons/controls/OrbitControls.js';
import Stats from 'three/addons/libs/stats.module.js';

const scene = new THREE.Scene();

const camera = new THREE.PerspectiveCamera(70, 800 / 600, 0.1, 50);
camera.position.set(2, 3, 5);
camera.lookAt(0, 0, 0);

const renderer = new THREE.WebGLRenderer({ antialias: true });
renderer.setSize(800, 600);
document.body.appendChild(renderer.domElement);

// Cubo proveniente da Parte III.
const geo = new THREE.BoxGeometry(1, 1, 1);
const material = new THREE.MeshNormalMaterial();
const cube = new THREE.Mesh(geo, material);
cube.position.y = 0.5;
scene.add(cube);

const axis = new THREE.AxesHelper();
scene.add(axis);

const grid = new THREE.GridHelper();
scene.add(grid);

const controls = new OrbitControls(camera, renderer.domElement);
controls.target.set(0, 0.5, 0);
controls.update();

const stats = new Stats();
document.body.appendChild(stats.dom);

// Limitar as atualizações da animação a 60 por segundo.
let delta = 0;
const watch = new THREE.Timer();
const minlat = 1 / 60;

function animate() {
  requestAnimationFrame(animate);

  watch.update();
  delta += watch.getDelta();

  if (delta < minlat) return;

  cube.rotateX(0.01);
  cube.rotateY(0.02);

  controls.update();
  stats.update();
  renderer.render(scene, camera);

  delta %= minlat;
}

animate();
