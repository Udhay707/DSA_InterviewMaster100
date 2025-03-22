package main

type MinStack struct {
	array []int
	min   []int
}

func Constructor() MinStack {
	return MinStack{make([]int, 0), make([]int, 0)}
}

func (this *MinStack) Push(val int) {
	if len(this.min) == 0 {
		this.min = append(this.min, val)
		this.array = append(this.array, val)
	} else {
		this.min = append(this.min, min(this.min[len(this.min)-1], val))
		this.array = append(this.array, val)
	}

}

func (this *MinStack) Pop() {
	l := len(this.min) - 1
	this.min = this.min[:l]
	this.array = this.array[:l]
}

func (this *MinStack) Top() int {
	return this.array[len(this.array)-1]
}

func (this *MinStack) GetMin() int {
	return this.min[len(this.min)-1]
}
