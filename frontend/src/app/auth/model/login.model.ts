export interface Login {
    username: string
    password: string
}

export interface ResponseLogin {
    accessToken: string
    tokenType: string
    role: string
}