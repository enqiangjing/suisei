import service from "./request.js";
import message_ from "@/components/common/Message.js";

// get
export function get_(api, params, url) {
    return service.request({
        method: 'get',
        timeout: 100000,
        url: api,
        baseURL: url,
        params: params
    }).then(response => response.data).catch((err) => {
        console.log(err)
    })
}

// post
export function post_(api, data, url) {
    return service.request({
        method: 'post',
        timeout: 100000,
        url: api,
        baseURL: url,
        headers: { 'Content-Type': 'application/json' },
        data: data
    }).then(response => {
        message_.run(response.errMsg, response.errCode)
        return response.data
    }).catch((err) => {
        console.log(err)
    })
}