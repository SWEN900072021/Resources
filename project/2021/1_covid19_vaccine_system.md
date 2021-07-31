## Project Overview

The Federal Government has recently released its plan to re-establish a "COVID-normal" in Australia, precipitated 
primarily on Australians receiving a dose of a COVID-19 vaccine. In order to assist with what is likely the single 
largest logistical challenge ever faced by this government, they require your help to build a vaccination booking 
and management system.

The application will be a centralised vaccine management platform that can help public health officials manage vaccine 
distribution at scale and expedite vaccine administration for a large population. The solution should provide real-time 
access to vaccine-administration data to support decision-making and distribution efforts.

## Application Domain

In this project, you and your team will implement an online vaccine booking and management application 
for the administration of COVID-19 vaccines. Through the application, Health Care Providers can list dates and times 
of bookings for vaccine administration and Vaccine Recipients can book them.

The application has a single Administrator. The Administrator has the ability to create accounts and add vaccine types 
(there are currently only two types: AstraZeneca and Pfizer). Each vaccine is suitable only for certain groups in 
Australia: the AstraZeneca vaccine is only able to be administered to Recipients 50 years or older, while the Pfizer 
vaccine can be administered to all Recipients.

The Administrator does not have the ability to create time-slots nor book for a vaccine. The Administrator has access 
to view all users and all time-slots available in the system, in order to monitor time-slots vacancy. The application 
must also provide them with the ability to view all vaccine recipients and filter by the type of vaccine received.

Vaccine Recipients are created in the system with biographical information, including date of birth. The application 
should provide Vaccine Recipients the ability to search for available time-slots in an area they specify with two 
different views:

1. The application should show a calendar view with all available time-slots at all Health Care Providers in a 
   particular area specified.
2. If the Vaccine Recipient specifies a particular Health Care Provider, the application should return a view of 
   time-slots only for that Health Care Provider.

Before being able to book a vaccine, Vaccine Recipients must answer a short questionnaire to determine eligibility 
(age and underlying health factors). This will be used to determine suitability of vaccines.

Health Care Providers are created in the system with details including name, postcode, and type of provider.

Health Care Providers can add any number of time-slots they have available. The application should allow them to add 
time-slots up to 6 months in advance on weekdays and weekends. The Administrator does not verify number of vaccines and 
time-slots available - it is assumed Health Care Providers are being truthful. Time-slot duration should be 
customisable.

Health Care Providers are responsible for recording a vaccination against a Vaccine Recipient once it is administered 
(Vaccine Recipients cannot be trusted to do this in case people create fake records of vaccination).

Once vaccinated, a Vaccine Recipient should be able to use the application to access a vaccination certificate to show 
proof of vaccination.
