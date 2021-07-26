## Project Overview

Australia currently has a fragmented and disparate system for maintaining Patient health care records. Medical records
are created by Health Care Providers (GPs, dermatologists, surgeons, etc) to record a medical history of treatments
given to a Patient. Currently, these medical records are kept by Health Care Providers leading to a lack of coordination
of medical treatment across providers and an inability for Patients to oversee their own medical history. For example,
if a Patient changes Health Care Providers, the new Health Care Provider has no visibility on prior treatments given
to the Patient.

There have been attempts to unify the system in the past (in countries like the U.K. and Australia, for example),
however, the rollouts were all plagued by issues of patient privacy. There is an opportunity to implement a system that
will be widely used and addresses the shortcomings of the current systems.

## Application Domain

In this project, you and your team are tasked with implementing a central repository of medical records for Patients in
Australia. Using the application, Health Care Providers create Patient records. Patients and Health Care Providers then
use the application to view these records.

The application has a single Administrator. The Administrator has the ability to add users to the system. The
Administrator can also view the list of all users (including Health Care Providers and Patients). The Administrator
does not have the ability to view Patient records nor upload Patient records.

Patients are Australian citizens who seek medical treatment from a Health Care Provider. A Health Care Provider is an
individual health professional or a health facility organisation licensed to provide health care diagnosis and treatment
services including medication, surgery and medical devices. For example, GPs, dermatologists, surgeons, and so on.

Patient records are created in the system with date of treatment, cost, Health Care Provider who provided treatment,
and a free text field for notes.

The application gives access to patients to view their entire medical history and to give consent to Health Care
Providers to create or view medical records. *Health Care Providers cannot view nor create Patient records without first
requesting and receiving consent from the Patient. The Patient has the ability to rescind consent at anytime which would
stop the Health Care Provider from viewing and creating Patient records immediately.* Only Health Care Providers should
have the ability to request access to Patient records.

Once a Patient provides consent to a Health Care Provider, the Health Care Provider can use the application to view the
Patient's entire medical records history, create new medical records, and edit records. *Health Care Providers can only
amend the Patient records they themselves have created.*

The application should provide Patients two ways of viewing their records:

1. Patients should be able to view their records as a chronological history of treatment (i.e. displayed in ascending
or descending order).
2. Patients should be able to view their records grouped by Health Care Provider (i.e. a list of all Health Care
Providers should be displayed and a Patient can click each Health Care Provider to view an entire list of their
treatment history).

Health Care Providers should have the same chronological view but they should be able to view records by Patient they
have treated.


