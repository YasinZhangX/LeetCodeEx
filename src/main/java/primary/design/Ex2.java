package primary.design;

import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *     push(x) -- 将元素 x 推入栈中。
 *     pop() -- 删除栈顶的元素。
 *     top() -- 获取栈顶元素。
 *     getMin() -- 检索栈中的最小元素。
 *
 * 方法1(复杂，空间使用少)：通过存入x-min实现，每次pop时判断返回值正负，正值说明压入数据时min没有变化，
 *                      负值说明压入数据时min变化，则更新min(min=min-pop())
 * 方法2(简单，空间使用大)：通过两个栈实现，数据栈+最小值栈（每次最小值更新时入栈）
 *
 * @author Yasin Zhang
 */
public class Ex2 {

    private Stack<Long> stack = new Stack<>();;
    private long min;

    /** initialize your data structure here. */
    public Ex2() {
    }

    public void push(int x) {
        if (stack.empty()) {
            stack.push((long)0);
            min = x;
        } else {
            stack.push((long)x-min);
            if (x < min) {
                min = x;
            }
        }
    }

    public void pop() {
        if (!stack.empty()) {
            if (stack.peek() < 0) {
                min = min - stack.peek();
            }
            stack.pop();
        }
    }

    public int top() throws RuntimeException {
        if (stack.empty()) {
            throw new RuntimeException("empty stack");
        } else {
            if (stack.peek() > 0) {
                 return (int)(min + stack.peek());
            } else {
                return (int)min;
            }
        }
    }

    public int getMin() throws RuntimeException {
        if (stack.empty()) {
            throw new RuntimeException("empty stack");
        } else {
            return (int)min;
        }
    }

}
