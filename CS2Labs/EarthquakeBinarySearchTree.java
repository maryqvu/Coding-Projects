/* Mary Vu
[CS2401 - FA23]
This work is to be done individually. It is not permitted to share, reproduce, or alter any part of this
assignment for any purpose. Students are not permitted from sharing code, uploading this
assignment online in any form, or viewing/receiving/modifying code written from anyone else. This
assignment is part of an academic course at The University of Texas at El Paso and a grade will be
assigned for the work produced individually by the student. */

public class EarthquakeBinarySearchTree {
    private Earthquake root;

    /**
     * Adds an earthquake object to the tree
     * @param quake
     * @return True if the earthquake was added to the tree
     */
    public boolean add(Earthquake quake) {
        if (root == null) {
            root = new Earthquake(quake);
            return true;
        } else {
            Earthquake current = root;
            Earthquake parent = root;

            while (current != null) {
                if (quake.getMagnitude() < current.getMagnitude()) {
                    parent = current;
                    current = current.left;
                } else if (quake.getMagnitude() > current.getMagnitude()) {
                    parent = current;
                    current = current.right;
                } else {
                    return false; // Duplicate node, element not inserted
                }
            }

            // Create a new node and attach it to the parent node
            if (quake.getMagnitude() < parent.getMagnitude()) {
                parent.left = new Earthquake(quake);
            } else {
                parent.right = new Earthquake(quake);
            }

            return true;
        }
    }

    /**
     * Iterative method: search and return the earthquake that matches the target
     * magnitude. If not earthquake is found, return null
     * 
     * @param targetMagnitude
     * @return An earthquake object or null
     */
    public Earthquake search(double targetMagnitude) {
        Earthquake current = root;
        while(current != null){
            if(current.getMagnitude() == targetMagnitude){
                return current;
            }
            if(current.getMagnitude() > targetMagnitude){
                current = current.left;
            }else if(current.getMagnitude() < targetMagnitude){
                current = current.right;
            }else{
                return null;
            }
        }
        return current;
    }

    public Earthquake searchRange(double minMag, double maxMag){
        return searchRange(root, minMag, maxMag);
    }

    private Earthquake searchRange(Earthquake node, double minMag, double maxMag){
        if(node == null){
            return null;
        }
        if(node.getMagnitude() < minMag){
            return searchRange(node.right, minMag, maxMag);
        }else if(node.getMagnitude() >= minMag && node.getMagnitude() <= maxMag){
                return node;
        }else{
            return searchRange(node.left, minMag, maxMag);
        }
    }

    /**
     * Display the tree. Don't modify this method
     */
    public void display() {
        if (root == null) {
            System.out.println("The tree is empty.");
        }
        inOrderTraversal(root);
    }

    /**
     * Helper recursive method: Use recursion to display the tree inOrder
     * @param current
     */
    private void inOrderTraversal(Earthquake current) {
        if(current == null){
            return;
        }
        if(current != null){
            inOrderTraversal(current.left);
            System.out.println("Earthquake [" + current.getMagnitude() + "    || Place: " + current.getPlace() + "   || Date: " + current.getDate() + "]");
            System.out.println();
            inOrderTraversal(current.right);
        }
    }
}