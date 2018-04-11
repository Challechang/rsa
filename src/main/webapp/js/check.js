/**
 * Created by rbcheng on 18-4-9.
 * Email: rbcheng@qq.com
 */

function checkPrime(value) {
    $.ajax({
        type: "get",
        url: "CheckPrimeServlet?num=" + value,
        async: true,
        success: function (data) {
            if (data == -1) {
                alert(value + " is Not a Valid Number.");
            } else if (data == 0) {
                alert(value + " is Not a Prime Number.");
            }
        }
    });
}

function checkRSAp() {
    var p = document.getElementById("rsa_p").value;
    checkPrime(p);
}

function checkRSAq() {
    var q = document.getElementById("rsa_q").value;

    checkPrime(q);
}

function checkRSAe() {

}

function generateRSAe() {

}

