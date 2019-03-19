class BinaryTreeNode(object):
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
        self.parent = None

    def add(self, val):
        if not self.left:
            self.left = BinaryTreeNode(val)
            self.left.parent = self
        elif not self.right:
            self.right = BinaryTreeNode(val)
            self.right.parent = self
        else:
            nodes = [self.left, self.right]
            for node in nodes:
                nodes.append(node.left)
                nodes.append(node.right)
                if not node.left:
                    node.left = BinaryTreeNode(val)
                    node.left.parent = node
                    break
                elif not node.right:
                    node.right = BinaryTreeNode(val)
                    node.right.parent = node
                    break

    def depth_first_traversal(self):
        node = self
        node.parent = 'root'
        nodes = []
        done = []
        status = True
        while status:
            print(node.val)
            if (not node.left and not node.right) or (node.left in done and node.right in done):
                print('Switch to parent node')
                done.append(node)
                node = node.parent
            elif node.left and node.left not in done:
                print('Switch to left node')
                node = node.left
            elif node.right and node.right not in done:
                print('Switch to right node')
                node = node.right
                done.append(node)
            elif node.parent in done:
                print('parent is done')
                del nodes[-1]
                status = False
        for n in nodes:
            print(n.val)




root = BinaryTreeNode('root')

root.add('L')
root.add('R')

root.add('LL')
root.add('LR')
root.add('RL')
root.add('RR')

root.depth_first_traversal()
