/*
 * Copyright (c) 2013. Codearte
 */
package eu.codearte.fairyland;

import eu.codearte.fairyland.producer.Company;
import eu.codearte.fairyland.producer.RandomDataGenerator;
import eu.codearte.fairyland.producer.RandomGenerator;
import eu.codearte.fairyland.producer.person.Person;
import eu.codearte.fairyland.producer.text.FairUtil;
import eu.codearte.fairyland.producer.text.Text;
import eu.codearte.fairyland.producer.text.TextProducer;
import eu.codearte.fairyland.producer.util.CalendarGenerator;
import eu.codearte.fairyland.producer.util.TimeProvider;

class FairyFactory {

    private static final int SEED = 1761283695;

    public static RandomDataGenerator createRandomDataGenerator(DataMaster dataMaster,
                                                                RandomGenerator randomGenerator,
                                                                CalendarGenerator randomCalendar) {
        return new RandomDataGenerator(dataMaster, randomGenerator, randomCalendar);
    }

    public static RandomGenerator createRandomGenerator() {
        return new RandomGenerator(SEED);
    }

    public static Text createText(DataMaster dataMaster,
                                  RandomGenerator randomGenerator,
                                  CalendarGenerator calendarGenerator) {
        return new Text(
                createTextProducer(dataMaster, randomGenerator, calendarGenerator),
                randomGenerator);
    }

    public static FairUtil createStringifyUtil(RandomGenerator randomGenerator, TimeProvider timeProvider) {
        return createStringifyUtil1(randomGenerator, timeProvider);
    }

    private static TextProducer createTextProducer(DataMaster dataMaster,
                                                   RandomGenerator randomGenerator,
                                                   CalendarGenerator calendarGenerator) {
        return new TextProducer(
                createRandomDataGenerator(dataMaster, randomGenerator, calendarGenerator),
                randomGenerator);
    }

    private static FairUtil createStringifyUtil1(RandomGenerator randomGenerator, TimeProvider dateProvider) {
        return new FairUtil(randomGenerator, dateProvider);
    }

    public static Person createPerson(DataMaster dataMaster,
                                      RandomGenerator randomGenerator,
                                      FairUtil fairUtil,
                                      CalendarGenerator calendarGenerator) {
        return new Person(
                randomGenerator,
                createRandomDataGenerator(dataMaster, randomGenerator, calendarGenerator),
                fairUtil);
    }

    public static Company createCompany(DataMaster dataMaster,
                                        RandomGenerator randomGenerator,
                                        CalendarGenerator calendarGenerator) {
        return new Company(
                randomGenerator,
                createRandomDataGenerator(dataMaster, randomGenerator, calendarGenerator));
    }
}
