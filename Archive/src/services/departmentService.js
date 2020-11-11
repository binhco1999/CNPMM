import { post } from 'jquery';
import Api from './api';
 
const list=()=>Api.get(Api.url.departments);
const get=id=>Api.get(`${Api.url.departments}/${id}`)

const add=data=>Api.post(Api.url.departments,data);
const update=(id,data)=>Api.put(`${Api.url.departments}/${id}`, data);
const remove=(id)=>Api.delete(`${Api.url.departments}/${id}`);

export default {
    list:list,
    get:get,
    add:add,
    update:update,
    delete:remove
}