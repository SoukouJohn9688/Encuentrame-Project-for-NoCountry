
  const datosImagenes = [
      {
        nombre: 'Lucas',
        ubicacion: 'No Country',
        imagenSrc: 'img/gatoespec1.jpg',
      },
      {
        nombre: 'Gaston',
        ubicacion: 'No Country',
        imagenSrc: 'img/perroespc1.jpg',
      },
      {
        nombre: 'Violeta',
        ubicacion: 'No Country',
        imagenSrc: 'img/gatoespec2.jpg',
      },
      {
        nombre: 'Bruma',
        ubicacion: 'No Country',
        imagenSrc: 'img/perroespec2.jpg',
      },
      {
        nombre: 'Tomi',
        ubicacion: 'No Country',
        imagenSrc: 'img/gatoespec3.jpg',
      },
      {
        nombre: 'Manchas',
        ubicacion: 'No Country',
        imagenSrc: 'img/perroespec3.jpg',
      },
      {
        nombre: 'Bigotes',
        ubicacion: 'No Country',
        imagenSrc: 'img/gatoespec4.jpg',
      },
      {
        nombre: 'Leon',
        ubicacion: 'No Country',
        imagenSrc: 'img/perroespec4.jpg',
      },
      {
        nombre: 'Matias',
        ubicacion: 'No Country',
        imagenSrc: 'img/perroespec5.jpg',
      },
      {
        nombre: 'Ziggy',
        ubicacion: 'No Country',
        imagenSrc: 'img/patitas11.jpg',
      },
      {
        nombre: 'Milo',
        ubicacion: 'No Country',
        imagenSrc: 'img/patitas12.jpg',
      },
      {
        nombre: 'Budín',
        ubicacion: 'No Country',
        imagenSrc: 'img/patitas13.jpg',
      },
      {
        nombre: 'Titan',
        ubicacion: 'No Country',
        imagenSrc: 'img/patitas14.jpg',
      },
    ];

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


    document.addEventListener('DOMContentLoaded', function () {
      const mosaicContainer = document.getElementById('mosaic-container');
      datosImagenes.forEach((item, index) => {
        const mosaicItem = document.createElement('div');
        mosaicItem.classList.add('mosaic-item');
        
        mosaicItem.innerHTML = `
        
          <a href="/listarMascota">
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
    