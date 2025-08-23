import math
from TreeNode import Node

class BST:
    def __init__(self):
        self.rootNode = None

    def height(self, node):
        """
        Calculate the height of a given node...
        Height is the number of edge from the node to the deepest leaf
        """
        if node is None:
            return -1
        return node.height

    def is_empty(self):
        """
        Check if the tree is empty...
        """
        return self.rootNode is None

    def display(self):
        """
        Initiates the display of the tree from the root...
        """
        self._display(self.rootNode, "Root Node: ")

    def _display(self, node, details):
        """
        A recursive helper function to display the tree structure...
        """
        if node is None:
            return
        print(details + str(node.data))

        self._display(node.leftNode, "Left child of "+str(node.data)+" is: ")
        self._display(node.rightNode, "Right child of " + str(node.data)+ " is: ")

    def insert(self, value):
        """
        Initiates the insertion of a new value into the tree...
        """
        self.rootNode = self._insert(value, self.rootNode)

    def _insert(self, value, node):
        """
        A recursive helper function to insert a new value...
        It also updates the height of the nodes after insertion...
        """
        if node is None:
            node = Node(value)
            return node
        if value < node.data:
            node.leftNode = self._insert(value, node.leftNode)
        elif value > node.data:
            node.rightNode = self._insert(value, node.rightNode)

        # Update the height...
        node.height = max(self.height(node.leftNode), self.height(node.rightNode)) + 1
        return node

    def balanced(self):
        """
        Checks if the tree is balanced from the root...
        A tree is balanced if for every node, the height of its left and right
        subtree differ by at most 1
        """
        return self._balanced(self.rootNode)

    def _balanced(self, node):
        """
        A recursive helper function to chek for balance...
        """
        if node is None:
            return True
        # Check the balance of the current node and it's subtrees
        return (abs(self.height(node.leftNode) - self.height(node.rightNode)) <= 1 and
                self._balanced(node.leftNode) and
                self._balanced(node.rightNode))

    def populate(self, nums):
        """
        Populate the tree with a list of numbers...
        """
        for num in nums:
            self.insert(num)

    def populate_sorted(self, nums):
        """
        Populate the tree with a sorted list of numbers...
        """
        self._populate_sorted(nums, 0, len(nums))

    def _populate_sorted(self, nums, start, end):
        """
        Helper function to populate a sorted list of numbers...
        """
        if start >= end:
            return
        mid = (start + end) // 2

        self.insert(nums[mid])
        self._populate_sorted(nums, start, mid)
        self._populate_sorted(nums, mid+1, end)

if __name__ == "__main__":
    tree = BST()
    # nums = [5, 2, 7, 1, 4, 6, 9, 8, 3, 10]
    # tree.populate(nums)
    # tree.display()
    # print("Tree is balanced: "+ str(tree.balanced()))

    nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    tree.populate_sorted(nums)
    tree.display()
    print("Tree is balanced: "+ str(tree.balanced()))