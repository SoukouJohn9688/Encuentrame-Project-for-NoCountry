
  const datosImagenes = [
      {
        nombre: 'Lucas',
        ubicacion: 'Santa Fe',
        imagenSrc: 'img/gatoespec1.jpg',
      },
      {
        nombre: 'Gaston',
        ubicacion: 'Santa Fe',
        imagenSrc: 'img/perroespc1.jpg',
      },
      {
        nombre: 'Violeta',
        ubicacion: 'Rosario',
        imagenSrc: 'img/gatoespec2.jpg',
      },
      {
        nombre: 'Bruma',
        ubicacion: 'Rosario',
        imagenSrc: 'img/perroespec2.jpg',
      },
      {
        nombre: 'Tomi',
        ubicacion: 'Santa Fe',
        imagenSrc: 'img/gatoespec3.jpg',
      },
      {
        nombre: 'Manchas',
        ubicacion: 'Rosario',
        imagenSrc: 'img/perroespec3.jpg',
      },
      {
        nombre: 'Bigotes',
        ubicacion: 'Rosario',
        imagenSrc: 'img/gatoespec4.jpg',
      },
      {
        nombre: 'Leon',
        ubicacion: 'Rosario',
        imagenSrc: 'img/perroespec4.jpg',
      },
      {
        nombre: 'Mantecol',
        ubicacion: 'Rosario',
        imagenSrc: 'img/perroespec5.jpg',
      },
      {
        nombre: 'Ziggy',
        ubicacion: 'Santa Fe',
        imagenSrc: 'img/patitas11.jpg',
      },
      {
        nombre: 'Milo',
        ubicacion: 'Rosario',
        imagenSrc: 'img/patitas12.jpg',
      },
      {
        nombre: 'Budín',
        ubicacion: 'Rosario',
        imagenSrc: 'img/patitas13.jpg',
      },
      {
        nombre: 'Titan',
        ubicacion: 'Rosario',
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
        
          <a href="descripcion.html">
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
    