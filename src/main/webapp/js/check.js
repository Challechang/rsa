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
            } else if (data == 1) {
                alert(value + " is a Valid Prime Number.")
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
    var p = document.getElementById("rsa_p").value;
    var q = document.getElementById("rsa_q").value;
    var e = document.getElementById("rsa_e").value;
    $.ajax({
        type: "get",
        url: "CheckPublicKeyServlet?rsa_e=" + e + "&rsa_p=" + p + "&rsa_q=" + q,
        async: true,
        success: function (data) {
            if (data == -1) {
                alert(e + " is Not a Valid Number.");
            } else if (data == 0) {
                alert(e + " is Not a Valid Public Key.");
            } else if (data == 1) {
                alert(e + " is a Valid Public Key.");
            }
        }
    });
}

function generateRSAp() {

    $.ajax({
        type: "get",
        url: "GeneratePrimeServlet",
        async: true,
        success: function (data) {
            document.getElementById("rsa_p").value = data;
        }
    });
}

function generateRSAq() {
    $.ajax({
        type: "get",
        url: "GeneratePrimeServlet",
        async: true,
        success: function (data) {
            document.getElementById("rsa_q").value = data;
        }
    });
}

function generateRSAe() {
    var p = document.getElementById("rsa_p").value;
    var q = document.getElementById("rsa_q").value;
    $.ajax({
        type: "get",
        url: "GeneratePublicKeyServlet?rsa_p=" + p + "&rsa_q=" + q,
        async: true,
        success: function (data) {
            if (data == "-1") {
                alert("p or q is Not Valid.");
            } else if (data == "-2") {
                alert("Public Key Not Exist.")
            } else {
                document.getElementById("rsa_e").value = data;
            }
        }
    });
}

function encode() {
    var p = document.getElementById("rsa_p").value;
    var q = document.getElementById("rsa_q").value;
    var e = document.getElementById("rsa_e").value;
    var plaintext = document.getElementById("rsa_plaintext").value;
    $.ajax({
        type: "get",
        url: "EncodeServlet?rsa_e=" + e + "&rsa_p=" + p + "&rsa_q=" + q + "&rsa_plaintext=" + plaintext,
        async: true,
        success: function (data) {
            if (data == "-1") {
                alert("p, q or e is Not Valid");
            } else if (data == "-3") {
                alert("Plaintext is Empty.");
            } else {
                var content = window.prompt("Ciphertext:", data);
                // document.write(content);
                // alert(data);
            }
        }
    });
}

function decode() {
    var p = document.getElementById("rsa_p").value;
    var q = document.getElementById("rsa_q").value;
    var e = document.getElementById("rsa_e").value;
    var ciphertext = document.getElementById("rsa_ciphertext").value;
    $.ajax({
        type: "get",
        url: "DecodeServlet?rsa_e=" + e + "&rsa_p=" + p + "&rsa_q=" + q + "&rsa_ciphertext=" + ciphertext,
        async: true,
        success: function (data) {
            if (data == "-1") {
                alert("p, q or e is Not Valid");
            } else if (data == "-3") {
                alert("Ciphertext is Empty.");
            } else {
                alert(data);
            }
        }
    });
}
