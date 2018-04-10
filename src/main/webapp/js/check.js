/**
 * Created by rbcheng on 18-4-9.
 * Email: rbcheng@qq.com
 */
function isPrime(num) {
    // 不是数字或者数字小于2
    /*if(!Number.isInteger(num)){　　　　　　// Number.isInterget 判断是否为整数
        return false;
    }*/
    num = parseInt(num);
    if (isNaN(num)) {
        // not a number
        return false;
    }

    //2是质数
    if(num == 2){
        return true;
    }else if(num % 2 == 0){  //排除偶数
        return false;
    }
    //依次判断是否能被奇数整除，最大循环为数值的开方
    var squareRoot = Math.sqrt(num);
    //因为2已经验证过，所以从3开始；且已经排除偶数，所以每次加2
    for(var i = 3; i <= squareRoot; i += 2) {
        if (num % i === 0) {
            return false;
        }
    }
    return true;
}

function checkRSAp() {
    var p = document.getElementById("rsa_p").value;

    $.ajax({
        type: "get",
        url: "CheckPrimeServlet?num=" + p,
        // async: true,
        success: function (data) {

            alert("from servlet: " + data);
        }
    });
}

function checkRSAq() {
    var q = document.getElementById("rsa_q").value;
    if (isPrime(q)) {
        alert("q: " + q + " is a Prime Number.");
    } else {
        alert("q: " + q + " is not a Prime Number.")
    }
}

