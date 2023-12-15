import java.util.*

fun main() {
    val list = mutableListOf<FlashCard>()

    list.add(FlashCard("Ledoux", "Royal Saltworks"))
    list.add(FlashCard("Labrouste", "Saint Geneive Library"))
    list.add(FlashCard("Schinkel", "Altes Museum"))
    list.add(FlashCard("Jefferson", "Academic Village"))
    list.add(FlashCard("Barry & Pugin", "Houses of Parliament"))
    list.add(FlashCard("Ruskin", "Oxford University Museum"))
    list.add(FlashCard("Baltard", "Les Halles Centrales"))
    list.add(FlashCard("Garnier", "Opera"))
    list.add(FlashCard("HH Richardson", "Church of Unity"))
    list.add(FlashCard("HH Richardson", "Trinity Church"))
    list.add(FlashCard("HH Richardson", "Trinity Church Rectory"))
    list.add(FlashCard("HH Richardson", "Ames Memorial Library"))
    list.add(FlashCard("HH Richardson", "Ames Gate Lodge"))
    list.add(FlashCard("HH Richardson", "Allegheny County Courthouse"))
    list.add(FlashCard("HH Richardson", "Marshall Field Warehouse and Wholesale Store"))
    list.add(FlashCard("Frank Lloyd Wright", "Home and Studio"))
    list.add(FlashCard("Frank Lloyd Wright", "Unity Temple"))
    list.add(FlashCard("Frank Lloyd Wright", "Robie House"))
    list.add(FlashCard("Frank Lloyd Wright", "Larkin Administration Building"))
    list.add(FlashCard("Frank Lloyd Wright", "Talesin East"))
    list.add(FlashCard("Frank Lloyd Wright", "Talesin West"))
    list.add(FlashCard("Frank Lloyd Wright", "Broadacre City"))
    list.add(FlashCard("Frank Lloyd Wright", "Fallingwater"))
    list.add(FlashCard("Frank Lloyd Wright", "Guggenheim Museum"))
    list.add(FlashCard("Adolf Loos", "American Bar"))
    list.add(FlashCard("Adolf Loos", "Villa Muller"))
    list.add(FlashCard("Corbusier", "Villa Savoye"))
    list.add(FlashCard("Mies van der rohe", "Barcelona Pavilion"))
    list.add(FlashCard("Mies van der rohe", "Seagram Building"))
    list.add(FlashCard("Kenzo Tange", "Atomic Memorial Museum"))
    list.add(FlashCard("Oscar Nimeyer & Lucio Costa", "Brasilia"))
    list.add(FlashCard("Rivera and Frida Kahlo", "House and Studio of Diego"))
    list.add(FlashCard("Luis Barragan", "Casa Barragan"))
    list.add(FlashCard("Robert Venturi", "Vanna Venturi House"))
    list.add(FlashCard("Alvar Aalto", "Saynatsalo City Hall"))
    list.add(FlashCard("Wang Shu and Lu Wenyu", "Ningbo History Museum"))
    list.add(FlashCard("Frank Gehry", "Guggenheim Museum Bilbao"))
    list.add(FlashCard("Zaha Hadid", "MAXXI Museum"))
    list.add(FlashCard("Maya Lin", "Vietnam Veterans Memorial"))
    list.add(FlashCard("Gunter Demnig", "Stolperstein (stumbling block)"))
    list.add(FlashCard("Rachel Whiteread", "Judenplatz Holocaust Memorial"))
    list.add(FlashCard("Peter Eisenman", "Memorial to the Murdered Jews of Europe"))
    list.add(FlashCard("Kehinde Wiley", "Rumors of War"))
    list.add(FlashCard("Equal Justice Initiative *with MASS Design Group", "National Memorial to Peace and Justice"))
    list.add(FlashCard("Lina Bo Bardi", "Sao Paolo Museum of Art"))
    list.add(FlashCard("Denise Scott Brown and Robert Venturi", "Sainsbury Wing, National Gallery of Art"))
    list.add(FlashCard("Studio Gang", "Aqua Tower"))
    list.add(FlashCard("Diller Scofidio + Renfro", "The High Line"))
    list.add(FlashCard("AWCPA.", "the Architectural Works Copyright Protection Act"))



    val scanner = Scanner(System.`in`)
    var answer = 0
    print("\u001b[H\u001b[2J")
    
    while(answer != -1){
        val questionGenerator = ::questionMakerAlt
        println("Enter -1 to quit\n")
        val listIndices = (0..list.size-1).toList().shuffled()
        
        // change this from 4 to any other number if you want a different amount of options
        val index = Random().nextInt(0,4)

        // update this list too if you change the upper-bound in the previous line
        val listOpts = listOf(
            list[listIndices[0]],
            list[listIndices[1]],
            list[listIndices[2]],
            list[listIndices[3]]
        )
        
        println(questionGenerator(listOpts, list[listIndices[index]]))

        answer = scanner.nextLine().toInt()
        if(answer == -1){
            break
        }
        list[listIndices[index]].update(listOpts[answer-1] == list[listIndices[index]])

        scanner.nextLine()
        print("\u001b[H\u001b[2J")
        list.shuffle()
    }
    println("Question".padEnd(47) + " Attempts Correct")
    list.forEach{it -> println("${it.question.padEnd(45)}->  ${it.totalAttempts}\t ${it.totalCorrect}")}
    println("\nTotal questions practiced: " + list.fold(0){acc:Int, item:FlashCard -> acc + item.totalAttempts})
}

data class FlashCard(val question: String, val answer: String, var totalAttempts: Int = 0, var totalCorrect: Int = 0){
    fun update(bool: Boolean): Unit{
        totalAttempts++
        if(bool) {
            println("Correct")
            totalCorrect++
        }
        else {
            println("Wrong")
        }
    }
}

fun questionMaker(list: List<FlashCard>, currentItem: FlashCard): String{
    var str = ""
    list.forEachIndexed{i, flashcard -> str += "${i+1}. ${flashcard.answer}\n"}
    return "Question: ${currentItem.question}\n" + str + "\nCurrent status = ${currentItem.totalAttempts} attempts, ${currentItem.totalCorrect} correct \nEnter your answer: "
}

fun questionMakerAlt(list: List<FlashCard>, currentItem: FlashCard): String{
    var str = ""
    list.forEachIndexed{i, flashcard -> str += "${i+1}. ${flashcard.question}\n"}
    return "Question: ${currentItem.answer}\n" + str + "\nCurrent status = ${currentItem.totalAttempts} attempts, ${currentItem.totalCorrect} correct \nEnter your answer: "
}

main()
println("...Program complete")