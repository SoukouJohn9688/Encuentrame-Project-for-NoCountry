const mosaicItems = document.querySelectorAll('.mosaic-item');

mosaicItems.forEach((item) => {
    const imagenTexto = item.querySelector('.imagen-texto');

    item.addEventListener('mouseover', () => {
        item.classList.add('enlarged');
        imagenTexto.style.display ='block';
    });

    item.addEventListener('mouseout', () => {
        item.classList.remove('enlarged');
        imagenTexto.style.display = 'none';
    });
});



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
  