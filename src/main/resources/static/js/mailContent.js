

$(document).ready(async function keywordNews() {
    try {
        // Send HTTP POST request to /dashboard/keywordNews
        const response = await $.ajax({
            type: 'post',
            url: '/dashboard/keywordNews',
            dataType: 'json'
        });

        // Process response array
        if (response != null) {
            const today = new Date();
            const year = today.getFullYear();
            const month = String(today.getMonth() + 1).padStart(2, '0');
            const day = String(today.getDate()).padStart(2, '0');
            for (const item of response) {
                const dto = JSON.stringify(item);
                const dto2 = JSON.parse(dto);
                const per = ((30 + dto2.score) / 60) * 100;

                // Send HTTP POST request to /dashboard/Newstext
                const body = await $.ajax({
                    type: 'post',
                    url: '/dashboard/Newstext',
                    data: 'text=' + dto2.url_Now,
                    dataType: 'text'
                });

                // Append HTML string to element with id of keywordNews
                document.getElementById('keywordNews').innerHTML += `
          <div class="collumn">
            <div class="head">
              <span class="headline hl5">${dto2.head_Now}</span>
              <p><span class="headline hl6">${dto2.name_Country}${dto2.name_Stock}<br>
              </span></p>
            </div>
            <p style="font-size: 20px; font-weight: bold"> ${dto2.class_Item}</p>
            <figure class="figure">
              <img class="media" src="${dto2.img}" alt="">
              <figcaption class="figcaption">${dto2.name_News} 사진자료</figcaption>
            </figure>
            <p>${body}</p>
          </div>
        `;
            }
        }
    } catch (error) {
        console.error(error);
    }
});

