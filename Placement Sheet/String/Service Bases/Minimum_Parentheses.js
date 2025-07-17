function minimumParentheses(str) {
    if (str == null || str.length == 0) {
        return -1;
    }

    let openBar = 0;
    let count = 1;
    let strArr = str.split('');
    for (let i = 0; i < strArr.length; i++) {
        if (str[i] === '(') {
            openBar++;
        } else if (str[i] === ')') {
            if (openBar > 0) {
                openBar--;
            } else {
                count++;
            }
        }
    }

    count += openBar;
    return count;
}

let str = "(())(()";
console.log(`Minimum parentheses required: ${minimumParentheses(str)}`);