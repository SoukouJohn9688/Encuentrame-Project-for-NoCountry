document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendario');
    var calendar = new FullCalendar.Calendar(calendarEl, {
        locale: 'es',
        initialView: 'dayGridMonth',
        events: [
            {
                title: 'Vacunación No-Country',
                start: '2024-02-29',
                end: '2025-02-30',
            },
            {
                title: 'Peluquería No-Country',
                start: '2024-03-10',
                end: '2025-12-07',
            }
            
        ],
        buttonText: {
            today: 'Hoy'
        },
        fixedWeekCount: false,
        height: 'auto',
    });
    calendar.render();

    

    var listaEventos = document.getElementById('lista-eventos');
    calendar.getEvents().forEach(function(event) {
        var eventoItem = document.createElement('li');
        eventoItem.textContent = event.title + ' - ' + event.start.toLocaleDateString();
        listaEventos.appendChild(eventoItem);
    });

    // document.querySelector('.fc-header-toolbar .fc-toolbar-chunk h2').style.textAlign = 'center';

});

