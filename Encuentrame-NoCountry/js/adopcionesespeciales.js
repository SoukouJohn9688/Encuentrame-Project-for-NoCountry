const datosImagenes = [
    {
      nombre: 'Lucas',
      ubicacion: 'Santa Fe',
      imagenSrc: 'img/patitas1.jpg',
    },
    {
      nombre: 'Mirko',
      ubicacion: 'Santa Fe',
      imagenSrc: 'img/patitas2.jpg',
    },
    {
      nombre: 'Dibu',
      ubicacion: 'Rosario',
      imagenSrc: 'img/patitas3.jpg',
    },
    {
      nombre: 'Praga',
      ubicacion: 'Rosario',
      imagenSrc: 'img/patitas4.jpg',
    },
    {
      nombre: 'Mila',
      ubicacion: 'Parana',
      imagenSrc: 'img/patitas5.jpg',
    },
    {
      nombre: 'Camilo',
      ubicacion: 'Rosario',
      imagenSrc: 'img/patitas6.jpg',
    },
    {
      nombre: 'Beni',
      ubicacion: 'Rosario',
      imagenSrc: 'img/patitas8.jpg',
    },
    {
      nombre: 'Zeus',
      ubicacion: 'Rosario',
      imagenSrc: 'img/patitas9.jpg',
    },
    {
      nombre: 'Uma',
      ubicacion: 'Rosario',
      imagenSrc: 'img/patitas10.jpg',
    },
    {
      nombre: 'Lobo',
      ubicacion: 'Rosario',
      imagenSrc: 'img/patitas11.jpg',
    },
    {
      nombre: 'Chocolata',
      ubicacion: 'Santa Fe',
      imagenSrc: 'img/patitas12.jpg',
    },
    {
      nombre: 'Silvestre',
      ubicacion: 'Santa Fe',
      imagenSrc: 'img/patitas13.jpg',
    },
    {
      nombre: 'Emma',
      ubicacion: 'Rosario',
      imagenSrc: 'img/patitas14.jpg',
    },
  ];

  document.addEventListener('DOMContentLoaded', function () {
    const mosaicContainer = document.getElementById('mosaic-container');
    datosImagenes.forEach((item, index) => {
      const mosaicItem = document.createElement('div');
      mosaicItem.classList.add('mosaic-item');
      
      mosaicItem.innerHTML = `
      
          <a href="#">
            <img src="${item.imagenSrc}" alt="Imagen ${index + 1}">
          </a>
          <div class="imagen-texto">
            <h3>Nombre: ${item.nombre}</h3>
            <p>Ubicación: ${item.ubicacion}</p>
          </div>
        
      `;

      mosaicContainer.appendChild(mosaicItem);
    });
  });
  


