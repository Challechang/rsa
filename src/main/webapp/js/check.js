/**
 * Created by rbcheng on 18-4-9.
 * Email: rbcheng@qq.com
 */
function checkPrime() {
}

function checkRSAp() {
    var p = document.getElementById("rsa_p").value;
    alert(p);
    checkPrime(p);
}

function checkRSAq() {
    var q = document.getElementById("rsa_q").value;
    alert(q);
    checkPrime(q)
}

