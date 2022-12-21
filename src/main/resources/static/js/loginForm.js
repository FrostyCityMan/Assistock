/**
 * Created by Muhammed Erdem on 10.10.2017.
 */

// $('.login').hide();

$('.signup').hide();
$('.recover-password').hide();
$('.loginoti').hide();
$('.dashlink').hide();


$('.btn-reset').click(function () {
    $('.login').hide();
    $('.recover-password').fadeIn(300);
});

$('.btn-member').click(function () {
    $('.login').hide();
    $('.signup').fadeIn(300);
});
$('.reginoti').hide();

//signin


function loginInsert() {
    // Check the value of the "Remember me" checkbox

    let remember = $('#remember').is(':checked');
    if (remember) {
        // Set a cookie to remember the user's login
        let expires = new Date();
        expires.setTime(expires.getTime() + (7 * 24 * 60 * 60 * 1000)); // 7 days
        document.cookie = "c_id=" + $('#Id').val() + "; expires=" + expires.toUTCString() + "; path=/";
    } else {
        // Remove the cookie if the user unchecks the box
        document.cookie = "c_id=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/";
    }
    let insertData = $('#Loginfrm').serialize();
    $.ajax({
        type: "POST",
        url: "/login/proc",
        data: insertData,
        dataType: "text",
        success: function (result) {
            if (result != "") {
                // Login succeeded
                $('.login form').hide();
                $('.title p').hide();
                $('.title a').hide();
                $('.dashlink').show();
                $('.or').hide();
                $('.btn-face').hide();
                $('.btn-twitter').hide();
                $('.login-name').text($('#Id').val());

                $('.loginoti').fadeIn(300);
            } else {
                // Login failed
                $('.error').text('아이디 또는 비밀번호가 올바르지 않습니다.');
            }
        },
        error: function (error) {
            // There was an error in the AJAX request
            console.error(error);
        }
    });
}

document.onkeypress = runlogin;

function runlogin(e) {
    if (e.keyCode == 13) {
        loginInsert();
    }
}

// register


function memberInsert() {
    let insertData = $('#registerMember').serialize();
    $.ajax({
        type: "POST",
        url: "/login/register",
        data: insertData,
        dataType: "json",
        success: function (result) {
            if (result != null) {
                $('.signup form').hide();
                $('.title p').hide();
                $('.or').hide();
                $('.btn-face').hide();
                $('.btn-twitter').hide();
                $('.reginoti').fadeIn(300);
                $('.regist-name').text($('#Name_Member').val());
            }// end of if
        },
        error: function (error) {
            $('.error').text('회원가입에 실패하였습니다.');

        }// end of success
    });//end of ajax
}//end of function


$('.btn-login').click(function () {
    $('.signup').hide();
    $('.recover-password').hide();
    $('.login').fadeIn(300);

});

$('.notification').hide();


function findInsert() {
    let insertData = $('#resetPassword').serialize();
    $.ajax({
        type: "POST",
        url: "/login/findID",
        data: insertData,
        dataType: "text",
        success: function (result) {
            if (result != null) {
                $('.reset-mail').text($('#resetPassword').val());
                $('.recover-password form').hide();
                $('.title p').hide();

                $('.notification').fadeIn(300);
            }// end of if
        },
        error: function (error) {
            $('.error').text('이메일을 확인해주세요.');


        }
    });
}


function validateForm() {
    const form = document.querySelector('#registerMember');
    // Get references to the form elements
    const RegiId = form.querySelector('#Regi_Id');
    const RegiPW = form.querySelector('#Regi_PW');
    const RePW = form.querySelector('#RePW');
    const NameMember = form.querySelector('#Name_Member');
    const Email = form.querySelector('#Email');
    const Tel = form.querySelector('#Tel');

    // Get the values of the form elements
    const id = RegiId.value;
    const password = RegiPW.value;
    const reEnteredPassword = RePW.value;
    const name = NameMember.value;
    const email = Email.value;
    const phone = Tel.value;

    // Validate the form values
    if (id.trim().length === 0) {
        // Display an error message if the ID is empty
        RegiId.nextElementSibling.innerHTML = 'ID는 필수 입력사항입니다.';
        return false;

    } else if (password.trim().length === 0) {
        // Display an error message if the password is empty
        RegiPW.nextElementSibling.innerHTML = '비밀번호는 필수 입력사항입니다.';
        return false;

    } else if (password !== reEnteredPassword) {
        // Display an error message if the passwords do not match
        RePW.nextElementSibling.innerHTML = '비밀번호가 일치하지 않습니다.';
        return false;

    } else if (name.trim().length === 0) {
        // Display an error message if the name is empty
        NameMember.nextElementSibling.innerHTML = '이름은 필수 입력사항입니다.';
        return false;

    } else if (email.trim().length === 0) {
        // Display an error message if the email is empty
        Email.nextElementSibling.innerHTML = '이메일은 필수 입력사항입니다.';
        return false;

    }

    if (id.value.length < 8 || id.value.length > 12) {
        alert("아이디는 8자 이상 12자 이하여야 합니다.");
        return false;
    }


    // Check that the email field contains a valid email address
    // (replace this with your own email validation code)
    if (!isValidEmail(email.value)) {
        alert("유효한 이메일 주소가 아닙니다.");
        return false;
    }


    // If all checks pass, return true to submit the form
    return true;

}


function isValidEmail(email) {
    var re = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/;
    return re.test(email);
}

// Display an error message if the


// Get the phone number field
var phone = document.getElementById("Tel");

// Add an event listener for the "input" event
phone.addEventListener("input", function(event) {
    // Get the current value of the phone field
    var value = this.value;

    // Remove all non-numeric characters
    value = value.replace(/\D/g, "");

    // Split the value into an array of characters
    var chars = value.split("");

    // Insert a dash after the third and seventh characters
    chars.splice(3, 0, "-");
    chars.splice(8, 0, "-");

    // Join the array of characters back into a string
    value = chars.join("");

    // Update the value of the phone field
    this.value = value;
});
