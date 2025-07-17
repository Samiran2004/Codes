function reverseStringWordWise(str) {
    if (str == null || str.length == 0) {
        return null;
    }

    let strArr = str.split(" ");
    let newStr = "";
    for (let i = strArr.length - 1; i >= 0; i--) {
        newStr += strArr[i];
        if (i > 0) {
            newStr += " ";
        }
    }

    return newStr;
}

let str = "Hello World of JS";
console.log(reverseStringWordWise(str));