class ParenthesisChecker {
    isMatchingPair(open: string, close: string): boolean {
        return (
            (open === '(' && close === ')') ||
            (open === '{' && close === '}') ||
            (open === '[' && close === ']')
        )
    }
    isBalanced(expression: string): boolean {
        const stack: string[] = [];
        for (const char of expression) {
            if (['(', '{', '['].includes(char)) {
                stack.push(char);
            } else if ([')', '}', ']'].includes(char)) {
                if (stack.length == 0 || !this.isMatchingPair(stack.pop()!, char)) {
                    return false;
                }
            }
        }
        return stack.length === 0;
    }
}

let expression: string = "[{{()}}]"

let checker: ParenthesisChecker = new ParenthesisChecker();

let isBalanced: boolean = checker.isBalanced(expression);

isBalanced == true ? console.log("Expression is balanced...") : console.log("Expression is not balanced...");

export { };