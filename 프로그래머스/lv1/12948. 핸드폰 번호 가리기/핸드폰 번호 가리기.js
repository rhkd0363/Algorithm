function solution(phone_number) {
    return [...phone_number].map((c, i) => i < phone_number.length - 4 ? '*' : c).join('')
}