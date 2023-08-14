let input = "({{}({)[]})"

let open = ["[","{","("];
let close = ["]","}",")"];

let sum = 0;
let stack = [];

for (let i=0; i<input.length; i++) {
    if(open.includes(input[i])) {
        stack.push(input[i]);
        sum++;
        continue;
    }

    if(close.includes(input[i])) {
        if (open.indexOf(stack.pop()) == close.indexOf(input[i])) sum--;
    }
}

if(sum == 0) {
    console.log(true);
} else {
    console.log(false);
}