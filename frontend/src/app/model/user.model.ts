export interface User {
    username: string
    password: string
    role: Role,
    enabled: boolean
}

enum Role {
    ADMIN,
    USER
}