package interviewQuestion

import java.util.*

/*
*The computer systems of N employees of a company are arranged in a row. A technical fault in the power supply has caused some of the systems to turn OFF, while the others remain ON.
Because of this, the employees whose systems are OFF are unable to work. The company does not like to see its employees sitting idle. So until the technical team can find the actual cause of the breakdown, the technical head Adam has devised a temporary workaround for the OFF systems at minimum cost.
Adam decides to connect all the OFF systems to the nearest ON system with the shortest possible length of cable. To make this happen, he calculates the distance of each system from the first system.
Task
Write an algorithm to help Adam find the minimum length of cable he needs to turn all the systems ON.

Input Format
The first line contains an integer systemState_size (N), representing the number of systems.
The second line consists of N space-separated integers:
systemState[1], systemState[2], ..., systemState[N]
Each integer represents the initial state of each system:
ON (1)
OFF (0)
The third line contains an integer dist_size (M), representing the number of distances.
The fourth line consists of M space-separated integers:
dist[1], dist[2], ..., dist[M]
Each integer represents the distance of each system from the first system.
Output Format
Print a single integer, representing the minimum length of cable Adam needs to turn all systems ON.

If no cable is needed, print 0.
Constraints 1 ≤𝑠
1≤systemState_size,dist_size≤10^5
1≤dist[i]<dist[i+1]≤10^9
1≤i<dist_size

Note
It is guaranteed that at least one system is ON.
None of the systems are faulty.
Example
Input:
3
1 0 0
3
1 5 6
Output:5
Explanation:
Length of cable required to connect the 2nd system to the 1st system = 4 (5 - 1).
Length of cable required to connect the 3rd system to the 2nd system = 1 (6 - 5).
Total cable length = 4 + 1 = 5.

Input:
7
1 0 1 1 0 1 1
7
1 5 6 7 8 9 17
Output: 2

Input:
8
0 1 0 0 1 1 0 0
8
3 5 10 12 13 23 30 38
Output: 20
Connecting 3 to 5, Cable Length = 2
Connecting 12 to 13, Cable Length = 1
Connecting 10 to 12, Cable Length = 2
Connecting 30 to 23, Cable Length = 7
Connecting 38 to 30, Cable Length = 8
Total Cable Length = 20

*
* */

fun main() {
    val scanner = Scanner(System.`in`)

    // Read number of systems
    val systemStateSize = scanner.nextInt() //Number of computer systems.
    val systemState = IntArray(systemStateSize) { scanner.nextInt() }  //Array representing ON (1) or OFF (0) systems.

    // Read number of distances
    val distSize = scanner.nextInt() //Number of distance values.
    val dist = IntArray(distSize) { scanner.nextInt() } // Array representing the distance of each system from the first system.

    scanner.close()

    // Find ON systems
    val onSystems = mutableListOf<Int>() //Stores the distances of systems that are already ON (1).
    val offSystems = mutableListOf<Int>() // Stores the distances of systems that are OFF (0).

    for (i in systemState.indices) {
        if (systemState[i] == 1) {
            onSystems.add(dist[i])
        } else {
            offSystems.add(dist[i])
        }
    }

    // Ensures OFF systems are processed in increasing order (left to right).
    offSystems.sort()

    var totalCableLength = 0

    // Connect OFF systems to the nearest ON system
//    for (off in offSystems) {
    offSystems.forEachIndexed { index, off ->
        // Find the nearest ON system
        val nearest = onSystems.minByOrNull { Math.abs(it - off) }!! //Find the closest ON system. minByOrNull { ... } → Finds the ON system with the smallest absolute difference (i.e., the nearest ON system).
        val nextNearest = if (index+1 < offSystems.size-1)onSystems.minByOrNull { Math.abs(it - offSystems[index+1]) }
        else 0
        val cableLength = if (nearest == nextNearest){
            Math.abs(off - offSystems[index+1])
        } else  Math.abs(nearest - off)

        // Debug output
        println("Connecting $off to $nearest, Cable Length = $cableLength")

        totalCableLength += cableLength
        onSystems.add(off) // Mark this OFF system as ON
    }

    println("Total Cable Length = $totalCableLength")
}
