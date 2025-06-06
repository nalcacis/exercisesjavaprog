package be.abis.exercise.test;

import be.abis.exercise.model.Person;
import be.abis.exercise.repository.MemoryPersonRepository;
import be.abis.exercise.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class LoggerTest {
    public static void main(String[] args) {

        Logger logger = LogManager.getLogger();
            logger.info("Hello World!");
        }
        }

