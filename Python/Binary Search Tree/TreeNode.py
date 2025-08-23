class Node:
    def __init__(self, data):
        self.data = data
        self.leftNode = None
        self.rightNode = None
        self.height = 0

    def get_value(self):
        return self.data