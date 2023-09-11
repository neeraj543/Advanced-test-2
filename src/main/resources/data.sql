insert into VENUE (ID, VENUE_NAME, LINK_MORE_INFO, CAPACITY,
                   FOOD_PROVIDED, INDOOR, OUTDOOR, FREE_PARKING_AVAILABLE,
                   CITY, DISTANCE_FROM_PUBLIC_TRANSPORT_IN_KM)
values (1, 'De Club', 'https://transitm.mechelen.be/de-club',
        150, false, true, false, true, 'Mechelen', 2);

insert into CLIENT (ID, NAME, NR_OF_ORDERS, TOTAL_AMOUNT, DISCOUNT_TAKEN)
values (1, 'Vera', '50', 5000, 100);
