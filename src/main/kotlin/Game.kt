fun main(args: Array<String>){
    val options = arrayOf("Rock","Paper","Scissors")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)

    val result = getResult(gameChoice, userChoice)
    println(result)

}

fun getGameChoice(optionsParam: Array<String>) = optionsParam[(Math.random() * optionsParam.size).toInt()]

fun getUserChoice(optionsParam: Array<String>): String{
    var isValidChoice = false
    var userChoice = ""

    //Ask for the user choice
    println("Please enter one of the following :")
    for (item in optionsParam) print(" $item")
    print(".")

    //read user input
    val userInput = readLine()

    //validation
    if (userInput != null && userInput in optionsParam){
        isValidChoice = true
        userChoice = userInput
    }

    if (!isValidChoice) println("You must enter a valid choice")

    return userChoice
}

fun getResult(gameChoice: String, userChoice: String): String{
    val message = "You chose $userChoice. I chose $gameChoice."
    val result: String


    if (userChoice == gameChoice) result = "Tie!"
    else if (
                (userChoice == "Rock" && gameChoice == "Scissors") ||
                (userChoice == "Paper" && gameChoice == "Rock") ||
                (userChoice == "Scissors" && gameChoice == "Paper")
            ) result = "You win!"
    else result = "You lose!"

    return message + " " + result
}