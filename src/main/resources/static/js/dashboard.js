document.addEventListener('DOMContentLoaded', function () {
    var modeSwitch = document.querySelector('.mode-switch');

    modeSwitch.addEventListener('click', function () {
        document.documentElement.classList.toggle('dark');
        modeSwitch.classList.toggle('active');
    });

    var listView = document.querySelector('.list-view');
    var gridView = document.querySelector('.grid-view');
    var projectsList = document.querySelector('.project-boxes');

    listView.addEventListener('click', function () {
        gridView.classList.remove('active');
        listView.classList.add('active');
        projectsList.classList.remove('jsGridView');
        projectsList.classList.add('jsListView');
    });

    gridView.addEventListener('click', function () {
        gridView.classList.add('active');
        listView.classList.remove('active');
        projectsList.classList.remove('jsListView');
        projectsList.classList.add('jsGridView');
    });

});

//worldcloud


$("#wordCloud").hide()
$("#loader-wrapper").hide()
$("#btn-research").hide()

// keywordDate.max = new Date().toISOString().split("T")[0];

function search1() {
    let insetData = $('#keywordFrm').serialize();
    console.log(insetData);
    $("#loader-wrapper").fadeIn(150)

    $(".timeline-container").hide();
    $('#keywordFrm').hide();
    $('#wordCloud')
        .empty()

    $.ajax({
            type: "POST",
            url: "/wordCloud",
            data: insetData,
            dataType: 'json',
            contentType: "application/x-www-form-urlencoded;charset=utf-8",
            success: function (result) {
                $("#wordCloud").fadeIn(500);
                $("#btn-research").fadeIn(300);
                $('.project-box-content-header').addClass('loaded');

                var data = JSON.parse(JSON.stringify(result));


                var chart = anychart.tagCloud();
                chart.data(data);
                var background = chart.background();
                background.fill('#fee4cb');
                chart.container("wordCloud");
                chart.hovered().fill("#5271ff");
                chart.mode("spiral");
                chart.textSpacing(5);
                chart.fontFamily("AppleGothic");
                chart.angles([0]);
                chart.draw();

            },//end of success
            error: function (result) {
                $('.project-box-content-header').addClass('loaded');
                $("#btn-research").fadeIn(300);

                alert("데이터가 없습니다!");
            }//end of error
        }
    )//end of ajax
}//end of function search

function research1() {
    $("#wordCloud").hide();
    $("#btn-research").hide();
    $('#keywordFrm').fadeIn(300);
    $("#loader-wrapper").hide()
    $(".timeline-container").fadeIn(300);


    $('.project-box-content-header').removeClass('loaded');
}

//대시보드 서버 데이터 -----------------------------

$(document).ready(function dashboard1() {

    $.ajax({
        type: "post",
        url: "/dashboard/count",
        dataType: "json",
        success: function (result) {
            if (result != null) {
                $('#todayNewsCount').text(result).val();
            }
        }
    })
})

//모달창 서버 전송-------------
$('.button-search').click(function save() {
    let data = {};
    $('#keyword-table tr').each(function () {
        let classInput = $(this).find('input[name="class"]').val();
        let valueInput = $(this).find('input[name="value"]').val();
        data[classInput] = valueInput;
    });
           console.log(data)


    $.ajax({
        type: "POST",
        url: "/dashboard/save",
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (result) {
            console.log('Success!');
        },
        error: function (error) {
            alert(error)
            console.log('Error:', error);
        }
    })//end of ajax
})//end of function


// /*time picker ---------------------------------*/
// BBC/Sport/football/Scores&Fixtures
$(document).ready(function () {
    // Timeline date picker slider scroller
    var move = "255px";
    var activeLeftPosition =
        $("div.active").val() !== undefined
            ? (activeLeftPosition = $("div.active").position().left)
            : (activeLeftPosition = 0);
    var activeWidth = $("div.active").width();
    var listWidth = $(".timeline-list").width();
    var center = activeLeftPosition + activeWidth / 2 - listWidth / 2;

    // on page load, center active div
    $(".timeline-list").animate({scrollLeft: "+=" + center}, "slow");

    $("div.active")
        .next("div.timeline-item")
        .css("border-left-width", "0");

    $(".prev-btn").click(function () {
        $(".timeline-list").animate({scrollLeft: "-=" + move});
    });

    $(".next-btn").click(function () {
        $(".timeline-list").animate({scrollLeft: "+=" + move});
    });
});


$("body").on("click", "[id^=datenum]", function (event) {

    console.log(this.id);
    var vId = this.id;
    let A = document.getElementById(vId);
    if (A.style.backgroundColor === 'rgb(226, 227, 229)') {
        // console.log(A.style.backgroundColor);
        $(".timeline-item").css('backgroundColor', '#fff');
        document.getElementById('datelist').value = null;
        // A.style.backgroundColor='#fff';
    } else {
        // console.log(A.style.backgroundColor);
        $(".timeline-item").css('backgroundColor', '#fff');
        A.style.backgroundColor = '#e2e3e5';
    }

});

//Modal--------------------------------------------------------


//Each time btn-search click it, the modal height increases by 30px
$(document).ready(function () {
    $(".btn-search").click(function () {
        let a = 30;
        $("#my_modal").css("height", "+=30px");
    });
});

function modal(id) {
    var zIndex = 9999;
    var modal = $('#' + id);

    // 모달 div 뒤에 희끄무레한 레이어
    var bg = $('<div>')
        .css({
            position: 'fixed',
            zIndex: zIndex,
            left: '0px',
            top: '0px',
            width: '100%',
            height: '100%',
            overflow: 'auto',
            // 레이어 색갈은 여기서 바꾸면 됨
            backgroundColor: 'rgba(0,0,0,0.4)'
        })
        .appendTo('body');

    modal
        .css({
            position: 'fixed',
            boxShadow: '0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)',

            // 시꺼먼 레이어 보다 한칸 위에 보이기
            zIndex: zIndex + 1,

            // div center 정렬
            top: '50%',
            left: '50%',
            transform: 'translate(-50%, -50%)',
            msTransform: 'translate(-50%, -50%)',
            webkitTransform: 'translate(-50%, -50%)'
        })
        .show()
        // 닫기 버튼 처리, 시꺼먼 레이어와 모달 div 지우기
        .find('.modal_close_btn')
        .on('click', function () {
            bg.remove();
            modal.hide();
        });
}

$('#popup_open_btn').on('click', function () {
    // 모달창 띄우기
    modal('my_modal');
});

// 모달 검색 1----------------------------------------------
let words = "";
$(document).ready(function dashboard1() {
    $.ajax({
        type: "post",
        url: "/dashboard/search",
        dataType: "json",
        success: function (result) {
            if (result != null) {
                words = result;
            }
        }
    })
})


const search = document.getElementById('search');
const suggestionsList = document.querySelector('.suggestions');

// Add an event listener to the search input field that listens for click events
search.addEventListener('click', function () {
    // Clear the suggestions list
    suggestionsList.innerHTML = '';

    // Display the suggestions list
    suggestionsList.style.display = 'block';

    // Add all the words in the words array to the suggestions list
    for (const word of words) {
        const li = document.createElement('li');
        li.textContent = word;

        // Add a click event listener to the li element that fills the search field with the selected word
        li.addEventListener('click', function () {
            search.value = word;
            suggestionsList.style.display = 'none';
        });

        suggestionsList.appendChild(li);
    }
});

// Add an event listener to the search input field
search.addEventListener('input', function () {
    // Get the value of the search field
    const searchValue = this.value.toLowerCase();

    // Clear the suggestions list
    suggestionsList.innerHTML = '';

    // Hide the suggestions list if the search field is empty
    if (searchValue === '') {
        suggestionsList.style.display = 'none';
        return;
    } else {
        suggestionsList.style.display = 'block';
    }

    // Add the matching search words to the suggestions list
    for (const word of words) {
        if (word.toLowerCase().includes(searchValue)) {
            const li = document.createElement('li');

            // Highlight the matching part of the search word
            const highlightedWord = word.replace(
                new RegExp(searchValue, 'i'),
                `<span class="highlight">${searchValue}</span>`
            );
            li.innerHTML = highlightedWord;

            // Add a click event listener to the li element that fills the search field with the selected word
            li.addEventListener('click', function () {
                search.value = word;
                suggestionsList.style.display = 'none';
            });

            suggestionsList.appendChild(li);
        }
    }
});

// Add a keydown event listener to the search field that allows the user to navigate the suggestions using the arrow keys
search.addEventListener('keydown', function (event) {
    if (event.key === 'ArrowDown' || event.key === 'ArrowUp') {
        event.preventDefault();

        // Get the currently selected suggestion
        const selected = document.querySelector('.selected');
        if (selected) {
            selected.classList.remove('selected');
        }

        // Get the list of suggestions
        const suggestions = document.querySelectorAll('.suggestions li');
        if (suggestions.length === 0) {
            return;
        }

        // Select the next or previous suggestion
        let newSelected;
        if (event.key === 'ArrowDown') {
            newSelected = selected ? selected.nextSibling : suggestions[0];
        } else {
            newSelected = selected ? selected.previousSibling : suggestions[suggestions.length - 1];
        }
        if (newSelected) {
            newSelected.classList.add('selected');
        }
    } else if (event.key === 'Enter') {
        // Get the currently selected suggestion
        const selected = document.querySelector('.selected');
        if (selected) {
            search.value = selected.textContent;
            suggestionsList.style.display = 'none';
        }
    }
});
// 모달 검색 2-------------------------------------------------------------
let words2 = '';
$(document).ready(function dashboard2() {
    $.ajax({
        type: "post",
        url: "/dashboard/search2",
        dataType: "json",
        success: function (result) {
            if (result != null) {
                words2 = result;
            }
        }
    })
})

const search2 = document.getElementById('search2');
const suggestionsList2 = document.querySelector('.suggestions2');

// Add an event listener to the search input field that listens for click events
search2.addEventListener('click', function () {
    // Clear the suggestions list
    suggestionsList2.innerHTML = '';

    // Display the suggestions list
    suggestionsList2.style.display = 'block';

    // Add all the words2 in the words2 array to the suggestions list
    for (const word of words2) {
        const li = document.createElement('li');
        li.textContent = word;

        // Add a click event listener to the li element that fills the search field with the selected word
        li.addEventListener('click', function () {
            search2.value = word;
            suggestionsList2.style.display = 'none';
        });

        suggestionsList2.appendChild(li);
    }
});

// Add an event listener to the search input field
search2.addEventListener('input', function () {
    // Get the value of the search field
    const searchValue = this.value.toLowerCase();

    // Clear the suggestions list
    suggestionsList2.innerHTML = '';

    // Hide the suggestions list if the search field is empty
    if (searchValue === '') {
        suggestionsList2.style.display = 'none';
        return;
    } else {
        suggestionsList2.style.display = 'block';
    }

    // Add the matching search words2 to the suggestions list
    for (const word of words2) {
        if (word.toLowerCase().includes(searchValue)) {
            const li = document.createElement('li');

            // Highlight the matching part of the search word
            const highlightedWord = word.replace(
                new RegExp(searchValue, 'i'),
                `<span class="highlight">${searchValue}</span>`
            );
            li.innerHTML = highlightedWord;

            // Add a click event listener to the li element that fills the search field with the selected word
            li.addEventListener('click', function () {
                search2.value = word;
                suggestionsList2.style.display = 'none';
            });

            suggestionsList2.appendChild(li);
        }
    }
});

// Add a keydown event listener to the search field that allows the user to navigate the suggestions using the arrow keys
search2.addEventListener('keydown', function (event) {
    if (event.key === 'ArrowDown' || event.key === 'ArrowUp') {
        event.preventDefault();

        // Get the currently selected suggestion
        const selected = document.querySelector('.selected');
        if (selected) {
            selected.classList.remove('selected');
        }

        // Get the list of suggestions
        const suggestions = document.querySelectorAll('.suggestions li');
        if (suggestions.length === 0) {
            return;
        }

        // Select the next or previous suggestion
        let newSelected;
        if (event.key === 'ArrowDown') {
            newSelected = selected ? selected.nextSibling : suggestions[0];
        } else {
            newSelected = selected ? selected.previousSibling : suggestions[suggestions.length - 1];
        }
        if (newSelected) {
            newSelected.classList.add('selected');
        }
    } else if (event.key === 'Enter') {
        // Get the currently selected suggestion
        const selected = document.querySelector('.selected');
        if (selected) {
            search2.value = selected.textContent;
            suggestionsList2.style.display = 'none';
        }
    }
});
// 모달 검색 3-------------------------------------------------------------
let words3 = '';
$(document).ready(function dashboard3() {
    $.ajax({
        type: "post",
        url: "/dashboard/search3",
        dataType: "json",
        success: function (result) {
            if (result != null) {
                words3 = result;
            }
        }
    })
})

const search3 = document.getElementById('search3');
const suggestionsList3 = document.querySelector('.suggestions2');

// Add an event listener to the search input field that listens for click events
search3.addEventListener('click', function () {
    // Clear the suggestions list
    suggestionsList3.innerHTML = '';

    // Display the suggestions list
    suggestionsList3.style.display = 'block';

    // Add all the words3 in the words3 array to the suggestions list
    for (const word of words3) {
        const li = document.createElement('li');
        li.textContent = word;

        // Add a click event listener to the li element that fills the search field with the selected word
        li.addEventListener('click', function () {
            search3.value = word;
            suggestionsList3.style.display = 'none';
        });

        suggestionsList3.appendChild(li);
    }
});

// Add an event listener to the search input field
search3.addEventListener('input', function () {
    // Get the value of the search field
    const searchValue = this.value.toLowerCase();

    // Clear the suggestions list
    suggestionsList3.innerHTML = '';

    // Hide the suggestions list if the search field is empty
    if (searchValue === '') {
        suggestionsList3.style.display = 'none';
        return;
    } else {
        suggestionsList3.style.display = 'block';
    }

    // Add the matching search words3 to the suggestions list
    for (const word of words3) {
        if (word.toLowerCase().includes(searchValue)) {
            const li = document.createElement('li');

            // Highlight the matching part of the search word
            const highlightedWord = word.replace(
                new RegExp(searchValue, 'i'),
                `<span class="highlight">${searchValue}</span>`
            );
            li.innerHTML = highlightedWord;

            // Add a click event listener to the li element that fills the search field with the selected word
            li.addEventListener('click', function () {
                search3.value = word;
                suggestionsList3.style.display = 'none';
            });

            suggestionsList3.appendChild(li);
        }
    }
});

// Add a keydown event listener to the search field that allows the user to navigate the suggestions using the arrow keys
search3.addEventListener('keydown', function (event) {
    if (event.key === 'ArrowDown' || event.key === 'ArrowUp') {
        event.preventDefault();

        // Get the currently selected suggestion
        const selected = document.querySelector('.selected');
        if (selected) {
            selected.classList.remove('selected');
        }

        // Get the list of suggestions
        const suggestions = document.querySelectorAll('.suggestions li');
        if (suggestions.length === 0) {
            return;
        }

        // Select the next or previous suggestion
        let newSelected;
        if (event.key === 'ArrowDown') {
            newSelected = selected ? selected.nextSibling : suggestions[0];
        } else {
            newSelected = selected ? selected.previousSibling : suggestions[suggestions.length - 1];
        }
        if (newSelected) {
            newSelected.classList.add('selected');
        }
    } else if (event.key === 'Enter') {
        // Get the currently selected suggestion
        const selected = document.querySelector('.selected');
        if (selected) {
            search3.value = selected.textContent;
            suggestionsList3.style.display = 'none';
        }
    }
});


// 모달 키워드 추가
let values = [];

$('#btn-item_class').click(function () {
    let query = document.getElementById("search").value;
    let classfy = document.getElementById("item_class").value;
    if (values.includes(query)) {
        alert("이미 있는 키워드 입니다.");
    } else {
        // code to add the value to the table goes here
        values.push(query);
        document.getElementById("keyword-table").innerHTML += `
  <tr>
    <td><input type="checkbox" class="cb"></td>
    <input type="hidden" name="class" value="${classfy}">
    <input type="hidden" name="value" value="${query}">
    <td>업종</td>
    <td>${query}</td>
  </tr>
`;
    }
    document.getElementById("search").value = "";
});

$('#btn-stock_class').click(function () {
    let query = document.getElementById("search2").value;
    let classfy = document.getElementById("stock_class").value;

    if (values.includes(query)) {
        alert("이미 있는 키워드 입니다.");
    } else {
        // code to add the value to the table goes here
        values.push(query);
        document.getElementById("keyword-table").innerHTML += `
  <tr>
  <td><input type="checkbox" class="cb"></td>
  <input type="hidden" name="class" value="${classfy}">
  <input type="hidden" name="value" value="${query}">
    <td>종목</td>
    <td>${query}</td>
  </tr>
`;
    }
    document.getElementById("search2").value = "";
});

$('#btn-country_class').click(function () {
    let query = document.getElementById("search3").value;
    let classfy = document.getElementById("country_class").value;

    if (values.includes(query)) {
        alert("이미 있는 키워드 입니다.");
    } else {
        // code to add the value to the table goes here
        values.push(query);
        document.getElementById("keyword-table").innerHTML += `
  <tr>
  <td><input type="checkbox" class="cb"></td>
  <input type="hidden" name="class" value="${classfy}">
  <input type="hidden" name="value" value="${query}">
    <td>국가</td>
    <td>${query}</td>
  </tr>
`;
    }
    document.getElementById("search3").value = "";
});

document.querySelector(".keyword-delete").addEventListener("click", function () {
    // code to handle delete button click goes here
    let checkboxes = document.querySelectorAll(".cb");
    let count = 0;
    for (let i = 0; i < checkboxes.length; i++) {
        let checkbox = checkboxes[i];
        if (checkbox.checked) {
            let td = checkbox.parentNode;
            let tr = td.parentNode;
            tr.parentNode.removeChild(tr);
            count++;
        }
    }
    $("#my_modal").css("height", "-=" + count * 30 + "px");
});


