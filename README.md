# SecretCommunicationApp

# Problem statement

Mulumba wants to create a system that will allow him to communicate secretly with his friend, Sipho. The system must allow him to send short scrambled 
(unreadable) messages to Sipho. Say if he wants to send the message “Hi”, the scrambled message must either be “KL” or “EF”, depending on the encryption 
or scrambling technique he chose. As can be seen, the system either replaces every letter in the original message with a letter that is 3-spaces away or a letter 
that is 3-spaces behind. The 3-spaces away letter substitution technique can be called Forward Substitution Encryption (FSE) and the 3-spaces behind letter 
substitution technique can be called Backward Substitution Encryption (BSE). 
On the other hand, when Sipho receives the scrambled messages, he needs to unscramble them back to their original state for readability purposes. If a message 
is scrambled using FSE, Sipho needs to use BSE to retrieve the original message. If BSE is used to scramble the message, FSE is needed to retrieve the original 
message.

# To do
Create an application that will allow Mulumba and Sipho to communicate in secret. The application must allow Mulumba to scramble a short message using 
either FSE or BSE. The scrambled message must be stored in a file. On the other hand, Sipho must be able to read the scrambled messages of Mulumba from a 
file. The read messages must be unscrambled and made readable. The readable form must be stored in a separate file.

#Very important information
Please make sure that your solution makes use of software reuse techniques (composition, inheritance and polymorphism). Use interfaces where applicable, 
exceptions and their handling, and files
