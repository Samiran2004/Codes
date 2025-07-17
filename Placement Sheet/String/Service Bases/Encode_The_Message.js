function encode(message) {
    if (message == null || message.length == 0) {
        return null;
    }

    let str = "";
    let strArr = message.split("");
    let i = 0;

    while (i < strArr.length) {
        let currElm = strArr[i];
        let count = 1;

        while (i + 1 < strArr.length && currElm == strArr[i + 1]) {
            count++;
            i++;
        }

        str += currElm + count;
        i++;
    }

    return str;
}

let message = "aabcccdeee";
console.log(`Encoded message: ${encode(message)}`);