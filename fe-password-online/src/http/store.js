// 存储
export function localStore(type = 'local', value = '') {
    if ((typeof value) === 'object') return localStorage.setItem(type, JSON.stringify(value));
    localStorage.setItem(type, value);
}

// 取值 默认需要转换为json对象
export function localData(type = 'local', value = true) {
    if (value) return JSON.parse(localStorage.getItem(type));
    return localStorage.getItem(type);
}

export function sessionStore(type = 'local', value = '') {
    if ((typeof value) === 'object') return sessionStorage.setItem(type, JSON.stringify(value));
    sessionStorage.setItem(type, value);
}

// 取值 默认需要转换为json对象
export function sessionData(type = 'local', value = true) {
    if (value) return JSON.parse(sessionStorage.getItem(type));
    return sessionStorage.getItem(type);
}