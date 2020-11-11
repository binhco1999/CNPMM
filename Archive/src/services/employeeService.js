import Api from './api'

const list=()=>Api.get(Api.url.employees)
const get=(id)=>Api.get(`${Api.url.employees}/${id}`)
export default{
    get:get,
    list:list
}