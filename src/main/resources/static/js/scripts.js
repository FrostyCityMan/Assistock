/*!
* Start Bootstrap - Blog Home v5.0.8 (https://startbootstrap.com/template/blog-home)
* Copyright 2013-2022 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-blog-home/blob/master/LICENSE)
*/
// This file is intentionally blank
// Use this file to add JavaScript to your project

//logout버튼

$('.btn-logout').click(function logout() {
    $.ajax({
        type: "POST",
        url: "/login/logout",

    });
})//end of btn logout

//슬라이드 점멸

let observer = new IntersectionObserver((e) => {
    e.forEach((box) => {
        if (box.isIntersecting) {
            box.target.style.opacity = 1;
        } else {
            box.target.style.opacity = 0;
        }
    })
})
observer.observe(document.getElementById('top-nv'))
observer.observe(document.getElementById('first-intro'))
observer.observe(document.getElementById('second-intro'))
observer.observe(document.getElementById('tab-es6'))
observer.observe(document.getElementById('tab-flexbox'))
observer.observe(document.getElementById('tab-react'))
observer.observe(document.getElementById('tab-angular'))
observer.observe(document.getElementById('tab-other'))


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
                $('#tab-es6').addClass('loaded');

                var data = JSON.parse(JSON.stringify(result));


                var chart = anychart.tagCloud();
                chart.data(data);

                chart.container("wordCloud");
                chart.hovered().fill("#5271ff");
                chart.mode("spiral");
                chart.textSpacing(5);
                chart.fontFamily("AppleGothic");
                chart.angles([0]);
                chart.draw();

            },//end of success
            error: function (result) {
                $('#tab-es6').addClass('loaded');
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

    $('#tab-es6').removeClass('loaded');
}


//------------------------- 슬라이더
class StickyNavigation {

    constructor() {
        this.currentId = null;
        this.currentTab = null;
        this.tabContainerHeight = 70;
        let self = this;
        $('.et-hero-tab').click(function () {
            self.onTabClick(event, $(this));
        });
        $(window).scroll(() => {
            this.onScroll();
        });
        $(window).resize(() => {
            this.onResize();
        });
    }

    onTabClick(event, element) {
        event.preventDefault();
        let scrollTop = $(element.attr('href')).offset().top - this.tabContainerHeight + 1;
        $('html, body').animate({scrollTop: scrollTop}, 600);
    }

    onScroll() {
        this.checkTabContainerPosition();
        this.findCurrentTabSelector();
    }

    onResize() {
        if (this.currentId) {
            this.setSliderCss();
        }
    }

    checkTabContainerPosition() {
        let offset = $('.et-hero-tabs').offset().top + $('.et-hero-tabs').height() - this.tabContainerHeight;
        if ($(window).scrollTop() > offset) {
            $('.et-hero-tabs-container').addClass('et-hero-tabs-container--top');
        } else {
            $('.et-hero-tabs-container').removeClass('et-hero-tabs-container--top');
        }
    }

    findCurrentTabSelector(element) {
        let newCurrentId;
        let newCurrentTab;
        let self = this;
        $('.et-hero-tab').each(function () {
            let id = $(this).attr('href');
            let offsetTop = $(id).offset().top - self.tabContainerHeight;
            let offsetBottom = $(id).offset().top + $(id).height() - self.tabContainerHeight;
            if ($(window).scrollTop() > offsetTop && $(window).scrollTop() < offsetBottom) {
                newCurrentId = id;
                newCurrentTab = $(this);
            }
        });
        if (this.currentId != newCurrentId || this.currentId === null) {
            this.currentId = newCurrentId;
            this.currentTab = newCurrentTab;
            this.setSliderCss();
        }
    }

    setSliderCss() {
        let width = 0;
        let left = 0;
        if (this.currentTab) {
            width = this.currentTab.css('width');
            left = this.currentTab.offset().left;
        }
        $('.et-hero-tab-slider').css('width', width);
        $('.et-hero-tab-slider').css('left', left);
    }

}

new StickyNavigation();


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

//금일 최고점 뉴스 (종목)
$(document).ready(function keywordNews() {
    $.ajax({
        type: "post",
        url: "/dashboard/maxNews",
        dataType: "json",
        success: function (response) {
            if (response != null) {
                var today = new Date();
                var year = today.getFullYear();
                var month = String(today.getMonth() + 1).padStart(2, '0');
                var day = String(today.getDate()).padStart(2, '0');
                for (var i = 0; i < response.length; i++) {
                    var dto = JSON.stringify(response[i]);
                    var dto2 = JSON.parse(dto);
                    var per = ((30 + dto2.score) / 60) * 100
                    var head = null;

                    document.getElementById("keywordMax").innerHTML += `
                <div class="project-box-wrapper" style="overflow:hidden;max-width:368px;">
                     <div class="project-box" style="background-color: #eee;">
                        <div class="project-box-header">
                            <span>${year + '-' + month + '-' + day}</span>
                            <div class="more-wrapper">
                                <button class="project-btn-more">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                         fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                         stroke-linejoin="round" class="feather feather-more-vertical">
                                        <circle cx="12" cy="12" r="1"/>
                                        <circle cx="12" cy="5" r="1"/>
                                        <circle cx="12" cy="19" r="1"/>
                                    </svg>
                                </button>
                            </div>
                        </div>
                        <div class="project-box-content-header">
                            <p class="box-content-header" style="font-size:18px">${dto2.name_Country}${dto2.name_Stock}</p>
                            <p class="box-content-subheader">${dto2.class_Item}</p>
                            <a href="/userNews">
                            <img class="newsImg" src="${dto2.img}"/>
                            <br>
                            <p class="box-content-subheader">${dto2.head_Now}</p>
                            </a>
<!--                            <a class="box-content-subheader" >${dto2.url_Now}</a>-->
                        </div>
                        <div class="box-progress-wrapper">
                            <p class="box-progress-header" id="s">Score ${dto2.score}</p>
                            <div class="box-progress-bar">
                                <span class="box-progress" style="width: ${per}%; background-color: #4f3ff0"></span>
                            </div>
                            <p class="box-progress-percentage">${per.toFixed(2)}%</p>
                        </div>
                        <div class="project-box-footer">
                            <div class="days-left" style="color: #4f3ff0;">
                                ${dto2.name_News}
                            </div>
                        </div>
                    </div>
                    </div>
                    `
                    console.log(dto2)
                }
            }
        }
    })
})


//금일 최고점 뉴스 (국가)
$(document).ready(function keywordNews() {
    $.ajax({
        type: "post",
        url: "/dashboard/maxNews2",
        dataType: "json",
        success: function (response) {
            if (response != null) {
                var today = new Date();
                var year = today.getFullYear();
                var month = String(today.getMonth() + 1).padStart(2, '0');
                var day = String(today.getDate()).padStart(2, '0');
                for (var i = 0; i < response.length; i++) {
                    var dto = JSON.stringify(response[i]);
                    var dto2 = JSON.parse(dto);
                    var per = ((30 + dto2.score) / 60) * 100
                    var head = null;

                    document.getElementById("keywordMax2").innerHTML += `
                <div class="project-box-wrapper" style="overflow:hidden;max-width:368px;">
                     <div class="project-box" style="background-color: #eee;">
                        <div class="project-box-header">
                            <span>${year + '-' + month + '-' + day}</span>
                            <div class="more-wrapper">
                                <button class="project-btn-more">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                         fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                         stroke-linejoin="round" class="feather feather-more-vertical">
                                        <circle cx="12" cy="12" r="1"/>
                                        <circle cx="12" cy="5" r="1"/>
                                        <circle cx="12" cy="19" r="1"/>
                                    </svg>
                                </button>
                            </div>
                        </div>
                        <div class="project-box-content-header">
                            <p class="box-content-header" style="font-size:18px">${dto2.name_Country}${dto2.name_Stock}</p>
                            <p class="box-content-subheader">${dto2.class_Item}</p>
                            <a href="/userNews">
                            <img class="newsImg" src="${dto2.img}"/>
                            <br>
                            <p class="box-content-subheader">${dto2.head_Now}</p>
                            </a>
<!--                            <a class="box-content-subheader" >${dto2.url_Now}</a>-->
                        </div>
                        <div class="box-progress-wrapper">
                            <p class="box-progress-header" id="s">Score ${dto2.score}</p>
                            <div class="box-progress-bar">
                                <span class="box-progress" style="width: ${per}%; background-color: #4f3ff0"></span>
                            </div>
                            <p class="box-progress-percentage">${per.toFixed(2)}%</p>
                        </div>
                        <div class="project-box-footer">
                            <div class="days-left" style="color: #4f3ff0;">
                                ${dto2.name_News}
                            </div>
                        </div>
                    </div>
                    </div>
                    `
                    console.log(dto2)
                }
            }
        }
    })
})