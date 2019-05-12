/**
 * The empty interface `IService` is an placehoder, for egg
 * to auto injection service to ctx.service
 *
 * @example
 *
 * import { Service } from 'egg';
 * class FooService extends Service {
 *   async bar() {}
 * }
 *
 * declare module 'egg' {
 *   export interface IService {
 *     foo: FooService;
 *   }
 * }
 *
 * Now I can get ctx.service.foo at controller and other service file.
 */
export interface IService { }// tslint:disable-line

export interface IController { } // tslint:disable-line
