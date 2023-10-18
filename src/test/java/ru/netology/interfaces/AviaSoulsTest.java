package ru.netology.interfaces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Moscow", "Yerevan", 12_350, 12_00, 14_45);
    Ticket ticket2 = new Ticket("Moscow", "Perm", 5_320, 7_35, 9_10);
    Ticket ticket3 = new Ticket("Sochi", "Kazan", 6_800, 11_15, 14_05);
    Ticket ticket4 = new Ticket("Yerevan", "Perm", 22_100, 20_00, 23_55);
    Ticket ticket5 = new Ticket("Perm", "Sochi", 15_800, 15_05, 16_30);
    Ticket ticket6 = new Ticket("Moscow", "Perm", 3_780, 21_15, 23_55);

    @Test
    public void shouldSortTicketByPriceFromMinToMax() {
        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);

        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Arrays.sort(tickets);

        Ticket[] expected = {ticket2, ticket3, ticket1, ticket5, ticket4};

        Assertions.assertArrayEquals(expected, tickets);
    }

    @Test
    public void shouldSearchTicketAndSortByPrice() {
        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);

        Ticket[] actual = avia.search("Moscow", "Perm");
        Ticket[] expected = {ticket6, ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneTicket() {
        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);

        Ticket[] actual = avia.search("Perm", "Sochi");
        Ticket[] expected = {ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchTicket() {
        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);

        Ticket[] actual = avia.search("Kazan", "Moscow");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByTime() {
        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Arrays.sort(tickets, timeComparator);

        Ticket[] expected = {ticket5, ticket2, ticket6, ticket1, ticket3, ticket4};

        Assertions.assertArrayEquals(expected, tickets);
    }

    @Test
    public void shouldSearchTicketAndSortByTime() {
        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] actual = avia.searchAndSortBy("Moscow", "Perm", timeComparator);
        Ticket[] expected = {ticket2, ticket6};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneTicketAndSortBy() {
        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] actual = avia.searchAndSortBy("Yerevan", "Perm", timeComparator);
        Ticket[] expected = {ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shoulNotdSearchTicketAndSortBy() {
        AviaSouls avia = new AviaSouls();
        avia.add(ticket1);
        avia.add(ticket2);
        avia.add(ticket3);
        avia.add(ticket4);
        avia.add(ticket5);
        avia.add(ticket6);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] actual = avia.searchAndSortBy("Perm", "Kazan", timeComparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

}