package it.polimi.ingsw.model.game;

import it.polimi.ingsw.exceptions.InvalidTurnException;
import it.polimi.ingsw.exceptions.InvalidAssistantException;
import it.polimi.ingsw.exceptions.InvalidStudentException;
import it.polimi.ingsw.exceptions.InvalidValueException;
import it.polimi.ingsw.model.player.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {

    Game game2players = new Game(GameMode.SIMPLEMODE,2, null);
    Game game3players = new Game(GameMode.SIMPLEMODE,3, null);
    Player player1;
    Player player2;
    Player player3;

    @Test
    void getState() {
        // Test 2 Players Game
        /*
        game2players.addPlayer("Daniele");
        assertEquals(GameState.WAITINGFORPLAYERS,game2players.getState());
        game2players.addPlayer("Giuseppe");
        assertEquals(GameState.PLAYING,game2players.getState());

        // Test 3 Players Game
        game3players.addPlayer("Daniele");
        assertEquals(GameState.WAITINGFORPLAYERS,game3players.getState());
        game3players.addPlayer("Giuseppe");
        assertEquals(GameState.WAITINGFORPLAYERS,game3players.getState());
        game3players.addPlayer("Samuele");
        assertEquals(GameState.PLAYING,game3players.getState());
        */
    }

    @Test
    void addPlayer() {
        // Test 2 Players Game
        assertEquals(0,game2players.getListOfPlayers().size());
        game2players.addPlayer("Daniele");
        player1 = game2players.getPlayer(1);
        assertTrue(game2players.getListOfPlayers().contains(player1));
        assertEquals(1,game2players.getListOfPlayers().size());
        assertEquals(Tower.WHITE,player1.getPlance().getTower());
        assertEquals(8,player1.getPlance().getNumOfTowers());
        assertEquals(7,player1.getPlance().getEntrance().size());
        game2players.addPlayer("Giuseppe");
        player2 = game2players.getPlayer(2);
        assertTrue(game2players.getListOfPlayers().contains(player2));
        assertEquals(2,game2players.getListOfPlayers().size());
        assertEquals(Tower.BLACK,player2.getPlance().getTower());
        assertEquals(8,player2.getPlance().getNumOfTowers());
        assertEquals(7,player2.getPlance().getEntrance().size());

        // Test 3 Players Game
        assertEquals(0,game3players.getListOfPlayers().size());
        game3players.addPlayer("Daniele");
        player1 = game3players.getPlayer(1);
        assertTrue(game3players.getListOfPlayers().contains(player1));
        assertEquals(1,game3players.getListOfPlayers().size());
        assertEquals(Tower.WHITE,player1.getPlance().getTower());
        assertEquals(6,player1.getPlance().getNumOfTowers());
        assertEquals(9,player1.getPlance().getEntrance().size());
        game3players.addPlayer("Giuseppe");
        player2 = game3players.getPlayer(2);
        assertTrue(game3players.getListOfPlayers().contains(player2));
        assertEquals(2,game3players.getListOfPlayers().size());
        assertEquals(Tower.BLACK,player2.getPlance().getTower());
        assertEquals(6,player2.getPlance().getNumOfTowers());
        assertEquals(9,player2.getPlance().getEntrance().size());
        game3players.addPlayer("Samuele");
        player3 = game3players.getPlayer(3);
        assertTrue(game3players.getListOfPlayers().contains(player3));
        assertEquals(3,game3players.getListOfPlayers().size());
        assertEquals(Tower.GREY,player3.getPlance().getTower());
        assertEquals(6,player3.getPlance().getNumOfTowers());
        assertEquals(9,player3.getPlance().getEntrance().size());
    }

    @Test
    void getBoard() {
    }

    @Test
    void getNumOfPlayers() {
        assertEquals(2,game2players.getNumOfPlayers());
        assertEquals(3,game3players.getNumOfPlayers());
    }

    @Test
    void getPlayer() {
    }

    @Test
    void winner() {
    }

    @Test
    void verifyProfessorControl() {
        game2players.addPlayer("Daniele");
        player1 = game2players.getPlayer(1);
        game2players.addPlayer("Giuseppe");
        player2 = game2players.getPlayer(2);
        player1.getPlance().addStudentEntrance(Student.RED);
        player1.getPlance().addStudentEntrance(Student.RED);
        player2.getPlance().addStudentEntrance(Student.RED);
        player1.getPlance().addStudentHall(Student.RED);
        player1.getPlance().addStudentHall(Student.RED);
        player2.getPlance().addStudentHall(Student.RED);
        game2players.verifyProfessorControl();
        assertEquals(Professor.RED_DRAGON, player1.getPlance().getProfessors().get(0));
    }

    @Test
    void startTurn() {
    }

    @Test
    void endTurn() {
    }

    @Test
    void moveStudentToHall() throws InvalidTurnException, InvalidStudentException {
        game2players.addPlayer("Daniele");
        player1 = game2players.getPlayer(1);
        game2players.addPlayer("Giuseppe");
        player2 = game2players.getPlayer(2);
        player1.setPlayerState(PlayerState.STUDENTPHASE);
        player1.getPlance().addStudentEntrance(Student.RED);
        player1.getPlance().addStudentEntrance(Student.BLUE);
        player1.getPlance().addStudentEntrance(Student.YELLOW);
       // System.out.println(player1.getPlance().getEntrance());
        try {
            game2players.moveStudentToHall(1, Student.RED);
            game2players.moveStudentToHall(1, Student.BLUE);
            game2players.moveStudentToHall(1, Student.YELLOW);
        }
        catch (InvalidStudentException e) {System.out.println("Errore");};
       // System.out.println(player1.getPlance().getEntrance());
        assertEquals(player1.getPlance().getNumberOfStudentHall(Student.RED),1);
        assertEquals(player1.getPlance().getNumberOfStudentHall(Student.BLUE),1);
        assertEquals(player1.getPlance().getNumberOfStudentHall(Student.YELLOW),1);
       // game2players.moveStudentToHall(1, Student.RED);
    }

    @Test
    void moveStudentToIsland() throws InvalidTurnException, InvalidStudentException {
        ArrayList<Student> students = new ArrayList<>();
        students.add(Student.RED);
        students.add(Student.BLUE);
        students.add(Student.YELLOW);
        game2players.addPlayer("Daniele");
        player1 = game2players.getPlayer(1);
        game2players.addPlayer("Giuseppe");
        player2 = game2players.getPlayer(2);
        player1.setPlayerState(PlayerState.STUDENTPHASE);
        player1.getPlance().addStudentEntrance(Student.RED);
        player1.getPlance().addStudentEntrance(Student.BLUE);
        player1.getPlance().addStudentEntrance(Student.YELLOW);
        game2players.moveStudentToIsland(1,game2players.getBoard().getArchipelago().getMothernature().isOn(),Student.RED);
        game2players.moveStudentToIsland(1,game2players.getBoard().getArchipelago().getMothernature().isOn(),Student.BLUE);
        game2players.moveStudentToIsland(1,game2players.getBoard().getArchipelago().getMothernature().isOn(),Student.YELLOW);
        assertEquals(game2players.getBoard().getArchipelago().getSingleIsland(game2players.getBoard().getArchipelago().getMothernature().isOn()).getStudents(),students);
    }

    @Test
    void useAssistant() throws InvalidAssistantException, InvalidTurnException {
        ArrayList<Assistant> wanted1 = new ArrayList<>(Arrays.asList(Assistant.values()));
        ArrayList<Assistant> wanted2 = new ArrayList<>(Arrays.asList(Assistant.values()));
        wanted1.remove(Assistant.CAT);
        wanted2.remove(Assistant.DOG);
        game2players.addPlayer("Daniele");
        player1 = game2players.getPlayer(1);
        game2players.addPlayer("Giuseppe");
        player2 = game2players.getPlayer(2);
        ArrayList<Player> playerorder = new ArrayList<>();
        playerorder = game2players.getPlayerorder();
        playerorder.add(0,player1);
        playerorder.add(1,player2);
        player1.setPlayerState(PlayerState.ASSISTANTPHASE);
        game2players.useAssistant(1,Assistant.CAT);
        player2.setPlayerState(PlayerState.ASSISTANTPHASE);
        game2players.useAssistant(2,Assistant.DOG);
        assertEquals(wanted1, player1.getAssistantCards());
        assertEquals(wanted2, player2.getAssistantCards());
    }

    @Test
    void moveMotherNature() throws InvalidTurnException, InvalidValueException, InvalidAssistantException {
        game2players.addPlayer("Daniele");
        player1 = game2players.getPlayer(1);
        game2players.addPlayer("Giuseppe");
        player2 = game2players.getPlayer(2);
        int num=0;
        ArrayList<Player> playerorder = new ArrayList<>();
        playerorder = game2players.getPlayerorder();
        playerorder.add(0,player1);
        playerorder.add(1,player2);
        player1.setLastassistantplayed(Assistant.CAT);
        player2.setLastassistantplayed(Assistant.DOG);


        for(Assistant assistant: Assistant.values()) {
            int j= game2players.getBoard().getArchipelago().getMothernature().isOn();
            player1.setPlayerState(PlayerState.ASSISTANTPHASE);
            game2players.useAssistant(1,assistant);
            player1.setPlayerState(PlayerState.MOTHERNATUREPHASE);
            Random rnd = new Random();
            game2players.moveMotherNature(1, num = (rnd.nextInt(assistant.getMovement())+1));
            assertEquals(((j + num - 1) % 12) + 1, game2players.getBoard().getArchipelago().getMothernature().isOn());
        }
    }

    @Test
    void useCharacter() {
    }

    @Test
    void getVerifyType() {
    }



    @Test
    void getListOfPlayers() {
    }

    @Test
    void verifyIslandInfluence() {
        game2players.addPlayer("Daniele");
        player1 = game2players.getPlayer(1);
        game2players.addPlayer("Giuseppe");
        player2 = game2players.getPlayer(2);
        player1.getPlance().addProfessor(Professor.RED_DRAGON);
        player1.getPlance().addProfessor(Professor.RED_DRAGON);
        player1.getPlance().addProfessor(Professor.GREEN_FROG);
        player2.getPlance().addProfessor(Professor.BLUE_UNICORN);
        game2players.getBoard().getArchipelago().getSingleIsland(2).addStudent(Student.RED);
        game2players.getBoard().getArchipelago().getSingleIsland(2).addStudent(Student.BLUE);
        game2players.getBoard().getArchipelago().getSingleIsland(2).addStudent(Student.GREEN);
        game2players.verifyIslandInfluence(2);
        assertEquals(Tower.WHITE, game2players.getBoard().getArchipelago().getSingleIsland(2).getTowerColor());
    }


    @Test
    void verifyPlayerOrder() {
        game3players.addPlayer("Daniele");
        player1 = game3players.getPlayer(1);
        game3players.addPlayer("Giuseppe");
        player2 = game3players.getPlayer(2);
        game3players.addPlayer("Giuseppe");
        player3 = game3players.getPlayer(3);

        //Set last played assistant
        player1.removeAssistant(Assistant.SNAKE);
        player2.removeAssistant(Assistant.TURTLE);
        player3.removeAssistant(Assistant.CAT);

        ArrayList<Player> playerorder = new ArrayList<>();
        playerorder.addAll(game3players.verifyPlayerOrder());

        int var=1;
        if(playerorder.get(0).getPlayerID() != player3.getPlayerID())
            var=-1;
        if(playerorder.get(1).getPlayerID() != player1.getPlayerID())
            var=-2;
        if(playerorder.get(2).getPlayerID() != player2.getPlayerID())
            var=-3;

        assertEquals(1,var);
    }

    @Test
    void startGame() {
    }
}