import java.util.*

fun main() {
    val list = mutableListOf<FlashCard>()
    list.add(FlashCard("Architecture Parlante", "architecture that gives an idea about its purpose through its form or appearance."))
    list.add(FlashCard("Panoptic plan", "plan where everything is visible from a central point"))
    list.add(FlashCard("Enlightenment Rationalism", "A movement emerged in the 18th century that argued that architecture's intellectual base is primarily in science as opposed to religious or archaic traditions."))
    list.add(FlashCard("Didactic architecture", "architecture that teaches"))
    list.add(FlashCard("Haussmanization", "the massive renovation of Paris by Baron Haussman in the 19th century"))
    list.add(FlashCard("Informal urbanism", "the development of a city without laws or other established means for regulating growth"))
    list.add(FlashCard("Rational town planning"," the systematic development of a city according to formalized, usually comprehensive and large-scale, plans"))
    list.add(FlashCard("Patte d\'oie (in French, a goose foot)", "node where multiple roads converge at different angles"))
    list.add(FlashCard("Dégagement", "the creation of open spaces for monuments, or the clearing away of buildings around monuments."))
    list.add(FlashCard("Material honesty", "leaving building materials unadorned and unaltered such that are visible and easily identifiable"))
    list.add(FlashCard("architectural promenade", "The choreographed movement of people into and/or through a building with the intention of giving them different views of the structure."))
    list.add(FlashCard("Rustication", "a decorative masonry technique where the faces of stones are left rough even as the blocks themselves take on a regular form."))
    list.add(FlashCard("Gesamtkunstwerk", "the total work of art. The self-conscious aesthetic integration of architecture, furniture, and decorative objects."))
    list.add(FlashCard("Inglenook", "flame corner"))
    list.add(FlashCard("light screen","glass for privacy"))
    list.add(FlashCard("Organic architecture", "a term used to describe buildings that take inspiration or recall natural forms."))
    list.add(FlashCard("Machine for Living", "A term invented by the Swiss architect Le Corbusier to describe the modern house."))
    list.add(FlashCard("Pilotis", "replacement of supporting walls by a grid of reinforced concrete columns that bears the structural load"))
    list.add(FlashCard("International Style", "A style characterized by the use of lightweight, mass-produced, industrial materials, rejection of all ornament and color, repetitive modular forms, and the use of flat surfaces, typically alternating with areas of glass."))
    list.add(FlashCard("Tropical Modernism", "a synthesis of Modernism and Brasilidade (“Brazilian-ness”) that presented a view of an industrially modern, yet exotic country."))
    list.add(FlashCard("Free Plan", "you don't have to divide the space using walls"))
    list.add(FlashCard("Critical Regionalism", "an architectural theory that aims to return to regional principles when building new structures."))
    list.add(FlashCard("Starchitect", "Celebrity Architects"))
    list.add(FlashCard("Anti-monumentalism", "a design approach that shuns or critiques the subjects, forms, meanings, and techniques traditionally used in monuments."))
    list.add(FlashCard("Vergangenheitsbewältigung", "the struggle to overcome the pas"))
    list.add(FlashCard("Modern-ish", "suggestive of modern style"))
    list.add(FlashCard("Less is a Bore", "Robert Venturi's idea about architecture, which says minimalism isn't the way to go"))

    val scanner = Scanner(System.`in`)
    var answer = 0

    print("\u001b[H\u001b[2J")
    while(answer != -1){
        val listIndices = (0..list.size-1).toList().shuffled()
        val index = Random().nextInt(0,4)

        println(questionMaker(listOf(
            list[listIndices[0]],
            list[listIndices[1]],
            list[listIndices[2]],
            list[listIndices[3]]
        ), list[listIndices[index]]))

        answer = scanner.nextLine().toInt()
        if(answer == -1){
            break
        }
        list[listIndices[index]].update(answer == index+1)

        scanner.nextLine()
        print("\u001b[H\u001b[2J")
        list.shuffle()
    }
    println("Question".padEnd(47) + " Attempts Correct")
    list.forEach{it -> println("${it.question.padEnd(45)}->  ${it.totalAttempts}\t ${it.totalCorrect}")}
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

main()