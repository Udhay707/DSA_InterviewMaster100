var maxProfit = function(prices) {
    let profit = 0;
    let currentProfit = 0;
    let previousLow = Number.MAX_VALUE;
    for (let price of prices){
        currentProfit = price - previousLow;
        profit = currentProfit > profit ? currentProfit : profit;
        previousLow = price < previousLow ? price : previousLow;
    }
    return profit;
};

let prices = [7,1,5,3,6,4]
let profit = maxProfit(prices)
console.log(profit)