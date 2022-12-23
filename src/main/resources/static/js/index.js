(function () {
    // $(".flex-container").waitForImages(
    //     function () {
    //     },
    //     $.noop,
    //     true
    // );
$(".assistockIcon").hide();
    $(".spinner").fadeOut(600);
    $(".flex-slide").each(function () {
        $(this).hover(
            function () {
                $(this).find(".assistockIcon").fadeIn(300);
                $(this).find(".flex-title").css({
                    transform: "rotate(0deg)",
                    top: "10%"
                });
                $(this).find(".flex-about").css({
                    opacity: "1"
                });
            },
            function () {
                $(this).find(".assistockIcon").fadeOut(300);
                $(this).find(".flex-title").css({
                    transform: "rotate(90deg)",
                    top: "15%"
                });
                $(this).find(".flex-about").css({
                    opacity: "0"
                });
            }
        );
    });
})();
