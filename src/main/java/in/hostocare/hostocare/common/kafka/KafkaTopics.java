package in.hostocare.hostocare.common.kafka;

public class KafkaTopics {

    // Notifications
    public static final String NOTIFICATION = "notification-topic";
    // Appointments
    public static final String APPOINTMENT_CREATED = "appointment-created-topic";
    public static final String APPOINTMENT_UPDATED = "appointment-updated-topic";
    public static final String APPOINTMENT_CANCELLED = "appointment-cancelled-topic";

    // Billing & Payments
    public static final String BILL_GENERATED = "bill-generated-topic";
    public static final String PAYMENT_SUCCESS = "payment-success-topic";
    public static final String PAYMENT_FAILED = "payment-failed-topic";

    // Patients
    public static final String PATIENT_CREATED = "patient-created-topic";
    public static final String PATIENT_UPDATED = "patient-updated-topic";

    // Users & Auth
    public static final String USER_REGISTERED = "user-registered-topic";
    public static final String USER_LOGIN = "user-login-topic";
    public static final String USER_ROLE_CHANGED = "user-role-changed-topic";

    // Doctors / Hospital
    public static final String DOCTOR_ONBOARDED = "doctor-onboarded-topic";
    public static final String DOCTOR_AVAILABILITY_UPDATED = "doctor-availability-updated-topic";

    // Audit & System
    public static final String AUDIT_LOG = "audit-log-topic";
    public static final String DEAD_LETTER = "dead-letter-topic";
}
