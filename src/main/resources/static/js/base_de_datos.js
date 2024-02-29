const datosImagenes = [
    {
      nombre: 'Lucas',
      ubicacion: 'No Country',
      imagenSrc: 'img/patitas1.jpg',
    },
    {
      nombre: 'a',
      ubicacion: 'No Country',
      imagenSrc: 'img/patitas2.jpg',
    },
    {
      nombre: 'a',
      ubicacion: 'No Country',
      imagenSrc: 'img/patitas3.jpg',
    },
    {
      nombre: 'a',
      ubicacion: 'No Country',
      imagenSrc: 'img/patitas4.jpg',
    },
    {
      nombre: 'a',
      ubicacion: '',
      imagenSrc: 'img/patitas5.jpg',
    },
    {
      nombre: 'a',
      ubicacion: 'No Country',
      imagenSrc: 'img/patitas6.jpg',
    },
    {
      nombre: 'a',
      ubicacion: 'No Country',
      imagenSrc: 'img/patitas8.jpg',
    },
    {
      nombre: 'a',
      ubicacion: 'No Country',
      imagenSrc: 'img/patitas9.jpg',
    },
    {
      nombre: 'a',
      ubicacion: 'No Country',
      imagenSrc: 'img/patitas10.jpg',
    },
    {
      nombre: '',
      ubicacion: 'No Country',
      imagenSrc: 'img/patitas11.jpg',
    },
    {
      nombre: 'l',
      ubicacion: 'No Country',
      imagenSrc: 'img/patitas12.jpg',
    },
    {
      nombre: 'l',
      ubicacion: 'No Country',
      imagenSrc: 'img/patitas13.jpg',
    },
    {
      nombre: 'L',
      ubicacion: 'No Country',
      imagenSrc: 'img/patitas14.jpg',
    },
  ];

  // Almacena los datos en localStorage
localStorage.setItem('datosImagenes', JSON.stringify(datosImagenes));

// Para acceder a los datos en otra página
const datosRecuperados = JSON.parse(localStorage.getItem('datosImagenes'));
