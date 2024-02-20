const datosImagenes = [
    {
      nombre: 'Lucas',
      ubicacion: 'Santa Fe',
      imagenSrc: 'img/patitas1.jpg',
    },
    {
      nombre: 'a',
      ubicacion: 'Santa Fe',
      imagenSrc: 'img/patitas2.jpg',
    },
    {
      nombre: 'a',
      ubicacion: 'Rosario',
      imagenSrc: 'img/patitas3.jpg',
    },
    {
      nombre: 'a',
      ubicacion: 'Rosario',
      imagenSrc: 'img/patitas4.jpg',
    },
    {
      nombre: 'a',
      ubicacion: '',
      imagenSrc: 'img/patitas5.jpg',
    },
    {
      nombre: 'a',
      ubicacion: 'Rosario',
      imagenSrc: 'img/patitas6.jpg',
    },
    {
      nombre: 'a',
      ubicacion: 'Rosario',
      imagenSrc: 'img/patitas8.jpg',
    },
    {
      nombre: 'a',
      ubicacion: 'Rosario',
      imagenSrc: 'img/patitas9.jpg',
    },
    {
      nombre: 'a',
      ubicacion: 'Rosario',
      imagenSrc: 'img/patitas10.jpg',
    },
    {
      nombre: '',
      ubicacion: 'Rosario',
      imagenSrc: 'img/patitas11.jpg',
    },
    {
      nombre: 'l',
      ubicacion: 'Rosario',
      imagenSrc: 'img/patitas12.jpg',
    },
    {
      nombre: 'l',
      ubicacion: 'Rosario',
      imagenSrc: 'img/patitas13.jpg',
    },
    {
      nombre: 'L',
      ubicacion: 'Rosario',
      imagenSrc: 'img/patitas14.jpg',
    },
  ];

  // Almacena los datos en localStorage
localStorage.setItem('datosImagenes', JSON.stringify(datosImagenes));

// Para acceder a los datos en otra página
const datosRecuperados = JSON.parse(localStorage.getItem('datosImagenes'));
