import java.util.*;

public class ThirdTask {

    public static Integer[] makingArrayOfDigits(List<String> listOfStrings) {
        LinkedList<Integer> listOfDigits = new LinkedList<>();
        for (String someString : listOfStrings) {
            String newString = someString.replace("(", "");
            newString = newString.replace(")", "");
            String[] twoStrings = newString.split(",");
            Integer[] twoDigits = {Integer.parseInt(twoStrings[0]), Integer.parseInt(twoStrings[1])};
            listOfDigits.add(twoDigits[0]);
            listOfDigits.add(twoDigits[1]);
        }
        Integer[] arrayOfDigits = {};
        arrayOfDigits = listOfDigits.toArray(arrayOfDigits);
        return arrayOfDigits;
    }

    public static Integer[] deletingFirstTwoElementsFromArray(Integer[] arrayOfIntegers) {
        Integer[] newArrayOfIntegers = new Integer[(arrayOfIntegers.length - 2)];
        int countForElementOfArrayOfIntegers = 2;
        for (int i = 0; i < arrayOfIntegers.length - 2; i++) {
            newArrayOfIntegers[i] = arrayOfIntegers[countForElementOfArrayOfIntegers];
            countForElementOfArrayOfIntegers++;
        }
        return newArrayOfIntegers;
    }

    public static Boolean TreeConstructor(Integer[] arrayOfDigits) {
        boolean setOfBinaryIsValid = true;
        Set<BinaryTree> setOfBinaryTrees = new LinkedHashSet<>();
        double variableForCountCycle = arrayOfDigits.length/2;
        int countFotCycle = (int)((Math.floor(variableForCountCycle) == variableForCountCycle) ? variableForCountCycle : (variableForCountCycle + 1));
        for (int i = 0; i < countFotCycle; i ++) {
            boolean thereIsConnectedBinaryTreeWithTheSameNumber = false;
            int k = 0;
            if (setOfBinaryTrees.isEmpty()) {
                BinaryTree someBinaryTree = new BinaryTree();
                someBinaryTree.setLeftChild(arrayOfDigits[i]);
                someBinaryTree.setTopParent(arrayOfDigits[i + 1]);
                someBinaryTree.setConnected(false);
                someBinaryTree.setFreeConnectionThisTopParentToOtherTree(true);
                someBinaryTree.setFreeConnectionThisLeftChildToOtherTree1(true);
                someBinaryTree.setFreeConnectionThisLeftChildToOtherTree2(true);
                someBinaryTree.setFreeConnectionThisRightChildToOtherTree1(true);
                someBinaryTree.setFreeConnectionThisRightChildToOtherTree2(true);
                setOfBinaryTrees.add(someBinaryTree);
                arrayOfDigits = deletingFirstTwoElementsFromArray(arrayOfDigits);
                thereIsConnectedBinaryTreeWithTheSameNumber= true;
                continue;
            } else {
                for (BinaryTree element : setOfBinaryTrees) {
                    if (element.getTopParent().equals(arrayOfDigits[k + 1])
                            && element.getRightChild() == null) {
                        element.setRightChild(arrayOfDigits[k]);
                        element.setConnected(true);
                        arrayOfDigits = deletingFirstTwoElementsFromArray(arrayOfDigits);
                        thereIsConnectedBinaryTreeWithTheSameNumber= true;
                        break;
                    } else if (element.getTopParent().equals(arrayOfDigits[k + 1])
                            && element.getLeftChild() == null) {
                        element.setLeftChild(arrayOfDigits[k]);
                        element.setConnected(true);
                        arrayOfDigits = deletingFirstTwoElementsFromArray(arrayOfDigits);
                        thereIsConnectedBinaryTreeWithTheSameNumber= true;
                        break;
                    }
                    if ( (element.getRightChild() != null && element.getRightChild().equals(arrayOfDigits[k + 1]) &&
                            (element.getFreeConnectionThisRightChildToOtherTree1().equals(true) || element.getFreeConnectionThisRightChildToOtherTree2().equals(true)) )
                    || (element.getLeftChild() != null && element.getLeftChild().equals(arrayOfDigits[k + 1])) &&
                            (element.getFreeConnectionThisLeftChildToOtherTree1().equals(true) || element.getFreeConnectionThisLeftChildToOtherTree2().equals(true))  ) {
                        BinaryTree someBinaryTree2 = new BinaryTree();
                        someBinaryTree2.setTopParent(arrayOfDigits[k + 1]);
                        someBinaryTree2.setLeftChild(arrayOfDigits[k]);
                        someBinaryTree2.setFreeConnectionThisTopParentToOtherTree(false);
                        someBinaryTree2.setFreeConnectionThisLeftChildToOtherTree1(true);
                        someBinaryTree2.setFreeConnectionThisLeftChildToOtherTree2(true);
                        someBinaryTree2.setFreeConnectionThisRightChildToOtherTree1(true);
                        someBinaryTree2.setFreeConnectionThisRightChildToOtherTree2(true);
                        element.setConnected(true);
                        someBinaryTree2.setConnected(true);
                        if (element.getRightChild() != null) {
                            if (element.getFreeConnectionThisRightChildToOtherTree1().equals(true)) {
                                element.setFreeConnectionThisRightChildToOtherTree1(false);
                            } else if (element.getFreeConnectionThisRightChildToOtherTree2().equals(true)) {
                                element.setFreeConnectionThisRightChildToOtherTree2(false);
                            }
                        }
                        if (element.getLeftChild() != null) {
                            if (element.getFreeConnectionThisLeftChildToOtherTree1().equals(true)) {
                                element.setFreeConnectionThisLeftChildToOtherTree1(false);
                            } else if (element.getFreeConnectionThisLeftChildToOtherTree2().equals(true)) {
                                element.setFreeConnectionThisLeftChildToOtherTree2(false);
                            }
                        }
                        setOfBinaryTrees.add(someBinaryTree2);
                        arrayOfDigits = deletingFirstTwoElementsFromArray(arrayOfDigits);
                        thereIsConnectedBinaryTreeWithTheSameNumber= true;
                        break;
                    }
                    if (element.getTopParent().equals(arrayOfDigits[k]) &&  element.getFreeConnectionThisTopParentToOtherTree()) {
                        BinaryTree someBinaryTree3 = new BinaryTree();
                        someBinaryTree3.setLeftChild(arrayOfDigits[k]);
                        if (element.getLeftChild() != null && element.getRightChild() != null) {
                            someBinaryTree3.setFreeConnectionThisLeftChildToOtherTree1(false);
                            someBinaryTree3.setFreeConnectionThisLeftChildToOtherTree2(false);
                        } else if (element.getLeftChild() != null) {
                            someBinaryTree3.setFreeConnectionThisLeftChildToOtherTree1(false);
                        } else if (element.getRightChild() != null) {
                            someBinaryTree3.setFreeConnectionThisRightChildToOtherTree2(false);
                        }
                        someBinaryTree3.setFreeConnectionThisRightChildToOtherTree1(true);
                        someBinaryTree3.setFreeConnectionThisRightChildToOtherTree2(true);
                        someBinaryTree3.setTopParent(arrayOfDigits[k + 1]);
                        someBinaryTree3.setFreeConnectionThisTopParentToOtherTree(true);
                        element.setConnected(true);
                        someBinaryTree3.setConnected(true);
                        element.setFreeConnectionThisTopParentToOtherTree(false);
                        setOfBinaryTrees.add(someBinaryTree3);
                        arrayOfDigits = deletingFirstTwoElementsFromArray(arrayOfDigits);
                        thereIsConnectedBinaryTreeWithTheSameNumber= true;
                        break;
                    }
                }
            }
            if (!thereIsConnectedBinaryTreeWithTheSameNumber) {
                BinaryTree someBinaryTree4 = new BinaryTree();
                someBinaryTree4.setLeftChild(arrayOfDigits[k]);
                someBinaryTree4.setTopParent(arrayOfDigits[k + 1]);
                someBinaryTree4.setConnected(false);
                someBinaryTree4.setFreeConnectionThisTopParentToOtherTree(true);
                someBinaryTree4.setFreeConnectionThisLeftChildToOtherTree1(true);
                someBinaryTree4.setFreeConnectionThisLeftChildToOtherTree2(true);
                someBinaryTree4.setFreeConnectionThisRightChildToOtherTree1(true);
                someBinaryTree4.setFreeConnectionThisRightChildToOtherTree2(true);
                setOfBinaryTrees.add(someBinaryTree4);
                arrayOfDigits = deletingFirstTwoElementsFromArray(arrayOfDigits);
            }
        }
        for (BinaryTree element: setOfBinaryTrees) {
            if (element.getConnected().equals(false)) {
                setOfBinaryIsValid = false;
            }
        }
        return setOfBinaryIsValid;
    }

    static class BinaryTree {
        Integer topParent;
        Integer leftChild;
        Integer rightChild;
        Boolean connected;
        Boolean freeConnectionThisTopParentToOtherTree;
        Boolean freeConnectionThisLeftChildToOtherTree1;
        Boolean freeConnectionThisLeftChildToOtherTree2;
        Boolean freeConnectionThisRightChildToOtherTree1;
        Boolean freeConnectionThisRightChildToOtherTree2;

        public BinaryTree() {
        }

        public void setTopParent(Integer topParent) {
            this.topParent = topParent;
        }

        public void setLeftChild(Integer leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(Integer rightChild) {
            this.rightChild = rightChild;
        }

        public Integer getTopParent() {
            return topParent;
        }

        public Integer getLeftChild() {
            return leftChild;
        }

        public Integer getRightChild() {
            return rightChild;
        }

        public Boolean getConnected() {
            return connected;
        }

        public void setConnected(Boolean connected) {
            this.connected = connected;
        }

        public Boolean getFreeConnectionThisTopParentToOtherTree() {
            return freeConnectionThisTopParentToOtherTree;
        }

        public void setFreeConnectionThisTopParentToOtherTree(Boolean freeConnectionThisTopParentToOtherTree) {
            this.freeConnectionThisTopParentToOtherTree = freeConnectionThisTopParentToOtherTree;
        }

        public Boolean getFreeConnectionThisLeftChildToOtherTree1() {
            return freeConnectionThisLeftChildToOtherTree1;
        }

        public void setFreeConnectionThisLeftChildToOtherTree1(Boolean freeConnectionThisLeftChildToOtherTree1) {
            this.freeConnectionThisLeftChildToOtherTree1 = freeConnectionThisLeftChildToOtherTree1;
        }

        public Boolean getFreeConnectionThisLeftChildToOtherTree2() {
            return freeConnectionThisLeftChildToOtherTree2;
        }

        public void setFreeConnectionThisLeftChildToOtherTree2(Boolean freeConnectionThisLeftChildToOtherTree2) {
            this.freeConnectionThisLeftChildToOtherTree2 = freeConnectionThisLeftChildToOtherTree2;
        }

        public Boolean getFreeConnectionThisRightChildToOtherTree1() {
            return freeConnectionThisRightChildToOtherTree1;
        }

        public void setFreeConnectionThisRightChildToOtherTree1(Boolean freeConnectionThisRightChildToOtherTree1) {
            this.freeConnectionThisRightChildToOtherTree1 = freeConnectionThisRightChildToOtherTree1;
        }

        public Boolean getFreeConnectionThisRightChildToOtherTree2() {
            return freeConnectionThisRightChildToOtherTree2;
        }

        public void setFreeConnectionThisRightChildToOtherTree2(Boolean freeConnectionThisRightChildToOtherTree2) {
            this.freeConnectionThisRightChildToOtherTree2 = freeConnectionThisRightChildToOtherTree2;
        }
    }

    public static void main(String[] args) {
        List<String> listOfIncomingData = new LinkedList<>();
        boolean functionWorking = true;
        while (functionWorking) {
            System.out.println("Please enter two numbers in next formst: \'(1,2)\'");
            Scanner s = new Scanner(System.in);
            String incomingData = s.nextLine();
            if (incomingData.equals("Q")) {
                functionWorking = false;
                continue;
            }
            if (!incomingData.matches("\\({1}" + "[0-9]{1,2}" + "\\,{1}" + "[0-9]{1,2}" + "\\){1}")) {
                System.err.println("Wrong data format");
                continue;
            }
            listOfIncomingData.add(incomingData);
            System.out.println("To stop program working please enter symbol \'Q\'");
        }
        System.out.println(TreeConstructor(makingArrayOfDigits(listOfIncomingData)));
    }
}